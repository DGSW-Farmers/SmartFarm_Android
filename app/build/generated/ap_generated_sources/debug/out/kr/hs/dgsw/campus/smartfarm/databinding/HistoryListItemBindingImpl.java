package kr.hs.dgsw.campus.smartfarm.databinding;
import kr.hs.dgsw.campus.smartfarm.R;
import kr.hs.dgsw.campus.smartfarm.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class HistoryListItemBindingImpl extends HistoryListItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.top_layout, 1);
        sViewsWithIds.put(R.id.item_title, 2);
        sViewsWithIds.put(R.id.item_start, 3);
        sViewsWithIds.put(R.id.item_end, 4);
        sViewsWithIds.put(R.id.item_img, 5);
        sViewsWithIds.put(R.id.arrow_btn, 6);
        sViewsWithIds.put(R.id.item_state_layout, 7);
        sViewsWithIds.put(R.id.background_img_humidity, 8);
        sViewsWithIds.put(R.id.humidity_title, 9);
        sViewsWithIds.put(R.id.progress_humidity, 10);
        sViewsWithIds.put(R.id.tv_humidity_value, 11);
        sViewsWithIds.put(R.id.background_img_temperature, 12);
        sViewsWithIds.put(R.id.temperature_title, 13);
        sViewsWithIds.put(R.id.progress_temperature, 14);
        sViewsWithIds.put(R.id.tv_temperature_value, 15);
        sViewsWithIds.put(R.id.background_img_level, 16);
        sViewsWithIds.put(R.id.level_title, 17);
        sViewsWithIds.put(R.id.progress_level, 18);
        sViewsWithIds.put(R.id.tv_level_value, 19);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public HistoryListItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }
    private HistoryListItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[12]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[4]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.TextView) bindings[3]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[7]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[17]
            , (android.widget.ProgressBar) bindings[10]
            , (android.widget.ProgressBar) bindings[18]
            , (android.widget.ProgressBar) bindings[14]
            , (android.widget.TextView) bindings[13]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[1]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[15]
            );
        this.historyLayout.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.history == variableId) {
            setHistory((kr.hs.dgsw.campus.smartfarm.HistoryData) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHistory(@Nullable kr.hs.dgsw.campus.smartfarm.HistoryData History) {
        this.mHistory = History;
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
        flag 0 (0x1L): history
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}