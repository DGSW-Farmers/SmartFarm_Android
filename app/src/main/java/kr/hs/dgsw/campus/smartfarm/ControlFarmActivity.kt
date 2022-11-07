package kr.hs.dgsw.campus.smartfarm

import android.Manifest
import android.app.AlertDialog
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import kr.hs.dgsw.campus.smartfarm.databinding.ActivityControlFarmBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.*

class ControlFarmActivity : AppCompatActivity(), View.OnClickListener {
    var led = false
    var pump: MutableList<Boolean> = mutableListOf(false, false, false)
    var ventilator = false
    private var currentposition: Int = 0
    private var fragment: Fragment? = null
    private var data: SensorData? = null
    var floor = 1
    private val timer = Timer()
    private lateinit var binding: ActivityControlFarmBinding

    private val REQUEST_BLUETOOTH_ENABLE = 100

    var mConnectedTask: ConnectedTask? = null
    var mBluetoothAdapter: BluetoothAdapter? = null
    private var mConnectedDeviceName: String? = null
    var isConnectionError = false
    private val TAG = "BluetoothClient"

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_control_farm)

        val TT: TimerTask = object : TimerTask() {
            override fun run() {
                getData(floor)
            }
        }
        timer.schedule(TT, 0, 5000) //Timer 실행

        initListener()

        binding.controlVp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                currentposition = position
            }
        })

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED
            || ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED){
            var permissions = arrayOf(
                android.Manifest.permission.BLUETOOTH_CONNECT,
                android.Manifest.permission.BLUETOOTH_ADMIN,
                android.Manifest.permission.BLUETOOTH,
                android.Manifest.permission.BLUETOOTH_SCAN,
            )
            ActivityCompat.requestPermissions(this, permissions, REQUEST_BLUETOOTH_ENABLE)
        }
        //--------------
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        if (mBluetoothAdapter == null) {
            showErrorDialog("This device is not implement Bluetooth.")
            return
        }
        if (!mBluetoothAdapter!!.isEnabled) {
            val intent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            startActivityForResult(intent, REQUEST_BLUETOOTH_ENABLE)
        } else {
            Log.d(TAG, "Initialisation successful.")
            showPairedDevicesListDialog()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    override fun onStop() {
        super.onStop()
        timer.cancel()
    }

    inner class ConnectTask internal constructor(bluetoothDevice: BluetoothDevice) :
        AsyncTask<Void?, Void?, Boolean>() {
        private var mBluetoothSocket: BluetoothSocket? = null
        private var mBluetoothDevice: BluetoothDevice? = null
        override fun doInBackground(vararg p0: Void?): Boolean {

            // Always cancel discovery because it will slow down a connection
            if (ActivityCompat.checkSelfPermission(
                    applicationContext,
                    Manifest.permission.BLUETOOTH_SCAN
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return false
            }
            mBluetoothAdapter!!.cancelDiscovery()

            // Make a connection to the BluetoothSocket
            try {
                // This is a blocking call and will only return on a
                // successful connection or an exception
                mBluetoothSocket!!.connect()
            } catch (e: IOException) {
                // Close the socket
                try {
                    mBluetoothSocket!!.close()
                } catch (e2: IOException) {
                    Log.e(
                        TAG, "unable to close() " +
                                " socket during connection failure", e2
                    )
                }
                return false
            }
            return true
        }

        override fun onPostExecute(isSucess: Boolean) {
            if (isSucess) {
                connected(mBluetoothSocket)
            } else {
                isConnectionError = true
                Log.d(TAG, "Unable to connect device")
                showErrorDialog("Unable to connect device")
            }
        }

        init {
            mBluetoothDevice = bluetoothDevice
            if (ActivityCompat.checkSelfPermission(
                    applicationContext,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) != PackageManager.PERMISSION_GRANTED
            ) {

            }
            mConnectedDeviceName = bluetoothDevice.name

            //SPP
            val uuid: UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb")
            try {
                mBluetoothSocket = mBluetoothDevice!!.createRfcommSocketToServiceRecord(uuid)
                Log.d(TAG, "create socket for $mConnectedDeviceName")
            } catch (e: IOException) {
                Log.e(TAG, "socket create failed " + e.message)
            }
            Toast.makeText(applicationContext, "연결중..", Toast.LENGTH_SHORT).show()
        }
    }

    inner class ConnectedTask internal constructor(socket: BluetoothSocket?) :
        AsyncTask<Void?, String?, Boolean>() {
        private var mInputStream: InputStream? = null
        private var mOutputStream: OutputStream? = null
        private var mBluetoothSocket: BluetoothSocket? = null
        override fun doInBackground(vararg p0: Void?): Boolean {
            val readBuffer = ByteArray(1024)
            var readBufferPosition = 0
            while (true) {
                if (isCancelled) return false
                try {
                    val bytesAvailable: Int = mInputStream!!.available()
                    if (bytesAvailable > 0) {
                        val packetBytes = ByteArray(bytesAvailable)
                        mInputStream!!.read(packetBytes)
                        for (i in 0 until bytesAvailable) {
                            val b = packetBytes[i]
                            if (b == '\n'.code.toByte()) {
                                val encodedBytes = ByteArray(readBufferPosition)
                                System.arraycopy(
                                    readBuffer, 0, encodedBytes, 0,
                                    encodedBytes.size
                                )
                                val recvMessage = String(encodedBytes, charset("UTF-8"))
                                readBufferPosition = 0
                                Log.d("TAG", "recv message: $recvMessage")
                                publishProgress(recvMessage)
                            } else {
                                readBuffer[readBufferPosition++] = b
                            }
                        }
                    }
                } catch (e: IOException) {
                    Log.e("TAG", "disconnected", e)
                    return false
                }
            }
        }

        override fun onProgressUpdate(vararg values: String?) {
//            mConversationArrayAdapter!!.insert(mConnectedDeviceName + ": " + values[0], 0)
        }

        override fun onPostExecute(isSucess: Boolean) {
            super.onPostExecute(isSucess)
            if (!isSucess) {
                closeSocket()
                Log.d(TAG, "Device connection was lost")
                isConnectionError = true
                showErrorDialog("Device connection was lost")
            }
        }

        override fun onCancelled(aBoolean: Boolean) {
            super.onCancelled(aBoolean)
            closeSocket()
        }

        fun closeSocket() {
            try {
                mBluetoothSocket!!.close()
                Log.d(TAG, "close socket()")
            } catch (e2: IOException) {
                Log.e(
                    TAG, "unable to close() " +
                            " socket during connection failure", e2
                )
            }
        }

        fun write(msg: String) {
            var msg = msg
            msg += "\n"
            try {
                mOutputStream!!.write(msg.toByteArray())
                mOutputStream!!.flush()
            } catch (e: IOException) {
                Log.e(TAG, "Exception during send", e)
            }
//            mInputEditText!!.setText(" ")
        }

        init {
            mBluetoothSocket = socket
            try {
                mInputStream = mBluetoothSocket!!.inputStream
                mOutputStream = mBluetoothSocket!!.outputStream
            } catch (e: IOException) {
                Log.e(TAG, "socket not created", e)
            }
            Log.d(TAG, "connected to $mConnectedDeviceName")
            Toast.makeText(applicationContext, "연결 되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun connected(socket: BluetoothSocket?) {
        mConnectedTask = ConnectedTask(socket)
        mConnectedTask!!.execute()
    }


    private fun showPairedDevicesListDialog() {
        val devices = if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.BLUETOOTH_CONNECT
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        } else {
            mBluetoothAdapter!!.bondedDevices
        }
        mBluetoothAdapter!!.bondedDevices
        val pairedDevices = devices.toTypedArray()
        if (pairedDevices.isEmpty()) {
            showQuitDialog(
                """
                No devices have been paired.
                You must pair it with another device.
                """.trimIndent()
            )
            return
        }
        val items: Array<String?> = arrayOfNulls(pairedDevices.size)
        for (i in pairedDevices.indices) {
            items[i] = pairedDevices[i].name
        }
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Select device")
        builder.setCancelable(false)
        builder.setItems(items, DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
            val task = ConnectTask(pairedDevices[which])
            task.execute()
        })
        builder.create().show()
    }


    private fun getData(floor: Int) {
        RetrofitBuilder.api.getData(floor).enqueue(object :
            Callback<SensorData> {
            override fun onResponse(
                call: Call<SensorData>,
                response: Response<SensorData>,
            ) {
                Log.d("testasd", response.body().toString())
                if (response.isSuccessful) {
                    data = response.body()
                    initVpAndIndicator()
                }
            }
            override fun onFailure(call: Call<SensorData>, t: Throwable) {
                Log.d("testasd", "실패$t")
            }
        })
    }

    private fun initVpAndIndicator() {
        binding.controlVp.adapter = ViewPagerAdapter(this)
        binding.controlVpIndicator.attachTo(binding.controlVp)
        binding.controlVp.currentItem = currentposition
    }


    private fun initListener() {
        binding.changeBtn.setOnClickListener(this)
        binding.firstFloorLayout.setOnClickListener(this)
        binding.secondFloorLayout.setOnClickListener(this)
        binding.thirdFloorLayout.setOnClickListener(this)
        binding.historyBtn.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        when (p0) {
            binding.changeBtn -> {
                val intent = Intent(this, MainActivity::class.java)
                finish()
                startActivity(intent)
            }
            binding.firstFloorLayout -> {
                floor = 1
                getData(floor)
                changeLayout(binding.firstFloorText)
            }
            binding.secondFloorLayout -> {
                floor = 2
                getData(floor)
                changeLayout(binding.secondFloorText)
            }
            binding.thirdFloorLayout -> {
                floor = 3
                getData(floor)
                changeLayout(binding.thirdFloorText)
            }
            binding.historyBtn -> {
                val intent = Intent(this, HistoryActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun changeLayout(view: View) {
        val list = listOf(binding.firstFloorText, binding.secondFloorText, binding.thirdFloorText)

        val layoutParams: ConstraintLayout.LayoutParams =
            view.layoutParams as ConstraintLayout.LayoutParams
        val RightMarginDp: Int =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 70F, resources.displayMetrics)
                .toInt()
        layoutParams.rightMargin = RightMarginDp
        view.layoutParams = layoutParams

        for (i in 0..2) {
            if (list[i] != view) {
                val mlayoutParams: ConstraintLayout.LayoutParams =
                    list[i].layoutParams as ConstraintLayout.LayoutParams
                val mRightMarginDp: Int =
                    TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        50F,
                        resources.displayMetrics
                    ).toInt()
                mlayoutParams.rightMargin = mRightMarginDp
                list[i].layoutParams = mlayoutParams
            }
        }
    }


    fun sendMessage(msg: String) {
        if (mConnectedTask != null) {
            mConnectedTask!!.write(msg)
            Log.d(TAG, "send message: $msg")
//            mConversationArrayAdapter!!.insert("Me:  $msg", 0)
        }
    }

    private inner class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            when (position) {
                0 -> {
                    val bundle = Bundle(3)
                    bundle.putInt("humidity", data!!.humidity.toFloat().toInt())
                    bundle.putInt("temperature", (data!!.temperature).toFloat().toInt())
                    bundle.putInt("waterLevel", data!!.waterLevel.toFloat().toInt())
                    fragment = StateFarmFirstFragment()
                    fragment!!.arguments = bundle


                }
                1 -> {
                    val bundle = Bundle(2)
                    bundle.putFloat("liquid", data!!.liquid.toFloat())
                    bundle.putFloat("sunlight ", data!!.sunlight.toFloat())
                    fragment = StateFarmSecondFragment()
                    fragment!!.arguments = bundle

                }
                else -> {
                    fragment = ControlFarmFragment(led, pump[floor-1], ventilator)
                }
            }
            return fragment!!
        }
    }

    private fun showErrorDialog(message: String?) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Quit")
        builder.setCancelable(false)
        builder.setMessage(message)
        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
            if (isConnectionError) {
                isConnectionError = false
                finish()
            }
        })
        builder.create().show()
    }

    fun showQuitDialog(message: String?) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Quit")
        builder.setCancelable(false)
        builder.setMessage(message)
        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
            finish()
        })
        builder.create().show()
    }
}