package kr.hs.dgsw.campus.smartfarm.databinding;
import kr.hs.dgsw.campus.smartfarm.R;
import kr.hs.dgsw.campus.smartfarm.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityControlFarmBindingImpl extends ActivityControlFarmBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.change_btn, 1);
        sViewsWithIds.put(R.id.change_img, 2);
        sViewsWithIds.put(R.id.farm_title, 3);
        sViewsWithIds.put(R.id.history_btn, 4);
        sViewsWithIds.put(R.id.history_text, 5);
        sViewsWithIds.put(R.id.img_thermometer, 6);
        sViewsWithIds.put(R.id.progress_thermometer, 7);
        sViewsWithIds.put(R.id.temperature_title, 8);
        sViewsWithIds.put(R.id.first_floor_layout, 9);
        sViewsWithIds.put(R.id.first_floor_text, 10);
        sViewsWithIds.put(R.id.second_floor_layout, 11);
        sViewsWithIds.put(R.id.second_floor_text, 12);
        sViewsWithIds.put(R.id.third_floor_layout, 13);
        sViewsWithIds.put(R.id.third_floor_text, 14);
        sViewsWithIds.put(R.id.drawer, 15);
        sViewsWithIds.put(R.id.top_layout, 16);
        sViewsWithIds.put(R.id.control_vp, 17);
        sViewsWithIds.put(R.id.control_vp_indicator, 18);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityControlFarmBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private ActivityControlFarmBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[1]
            , (android.widget.ImageView) bindings[2]
            , (androidx.viewpager2.widget.ViewPager2) bindings[17]
            , (com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator) bindings[18]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[15]
            , (android.widget.TextView) bindings[3]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ProgressBar) bindings[7]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[8]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.TextView) bindings[14]
            , (android.widget.LinearLayout) bindings[16]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}