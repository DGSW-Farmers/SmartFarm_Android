package kr.hs.dgsw.campus.smartfarm;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kr.hs.dgsw.campus.smartfarm.databinding.ActivityControlFarmBindingImpl;
import kr.hs.dgsw.campus.smartfarm.databinding.ActivityHistoryBindingImpl;
import kr.hs.dgsw.campus.smartfarm.databinding.ActivityMainBindingImpl;
import kr.hs.dgsw.campus.smartfarm.databinding.FragmentControlFarmBindingImpl;
import kr.hs.dgsw.campus.smartfarm.databinding.FragmentStateFarmFirstBindingImpl;
import kr.hs.dgsw.campus.smartfarm.databinding.FragmentStateFarmSecondBindingImpl;
import kr.hs.dgsw.campus.smartfarm.databinding.HistoryListItemBindingImpl;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYCONTROLFARM = 1;

  private static final int LAYOUT_ACTIVITYHISTORY = 2;

  private static final int LAYOUT_ACTIVITYMAIN = 3;

  private static final int LAYOUT_FRAGMENTCONTROLFARM = 4;

  private static final int LAYOUT_FRAGMENTSTATEFARMFIRST = 5;

  private static final int LAYOUT_FRAGMENTSTATEFARMSECOND = 6;

  private static final int LAYOUT_HISTORYLISTITEM = 7;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(7);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.hs.dgsw.campus.smartfarm.R.layout.activity_control_farm, LAYOUT_ACTIVITYCONTROLFARM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.hs.dgsw.campus.smartfarm.R.layout.activity_history, LAYOUT_ACTIVITYHISTORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.hs.dgsw.campus.smartfarm.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.hs.dgsw.campus.smartfarm.R.layout.fragment_control_farm, LAYOUT_FRAGMENTCONTROLFARM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.hs.dgsw.campus.smartfarm.R.layout.fragment_state_farm_first, LAYOUT_FRAGMENTSTATEFARMFIRST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.hs.dgsw.campus.smartfarm.R.layout.fragment_state_farm_second, LAYOUT_FRAGMENTSTATEFARMSECOND);
    INTERNAL_LAYOUT_ID_LOOKUP.put(kr.hs.dgsw.campus.smartfarm.R.layout.history_list_item, LAYOUT_HISTORYLISTITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYCONTROLFARM: {
          if ("layout/activity_control_farm_0".equals(tag)) {
            return new ActivityControlFarmBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_control_farm is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYHISTORY: {
          if ("layout/activity_history_0".equals(tag)) {
            return new ActivityHistoryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_history is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCONTROLFARM: {
          if ("layout/fragment_control_farm_0".equals(tag)) {
            return new FragmentControlFarmBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_control_farm is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSTATEFARMFIRST: {
          if ("layout/fragment_state_farm_first_0".equals(tag)) {
            return new FragmentStateFarmFirstBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_state_farm_first is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSTATEFARMSECOND: {
          if ("layout/fragment_state_farm_second_0".equals(tag)) {
            return new FragmentStateFarmSecondBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_state_farm_second is invalid. Received: " + tag);
        }
        case  LAYOUT_HISTORYLISTITEM: {
          if ("layout/history_list_item_0".equals(tag)) {
            return new HistoryListItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for history_list_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(7);

    static {
      sKeys.put("layout/activity_control_farm_0", kr.hs.dgsw.campus.smartfarm.R.layout.activity_control_farm);
      sKeys.put("layout/activity_history_0", kr.hs.dgsw.campus.smartfarm.R.layout.activity_history);
      sKeys.put("layout/activity_main_0", kr.hs.dgsw.campus.smartfarm.R.layout.activity_main);
      sKeys.put("layout/fragment_control_farm_0", kr.hs.dgsw.campus.smartfarm.R.layout.fragment_control_farm);
      sKeys.put("layout/fragment_state_farm_first_0", kr.hs.dgsw.campus.smartfarm.R.layout.fragment_state_farm_first);
      sKeys.put("layout/fragment_state_farm_second_0", kr.hs.dgsw.campus.smartfarm.R.layout.fragment_state_farm_second);
      sKeys.put("layout/history_list_item_0", kr.hs.dgsw.campus.smartfarm.R.layout.history_list_item);
    }
  }
}
