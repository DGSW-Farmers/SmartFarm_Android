// Generated by data binding compiler. Do not edit!
package kr.hs.dgsw.campus.smartfarm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import kr.hs.dgsw.campus.smartfarm.R;

public abstract class FragmentControlFarmBinding extends ViewDataBinding {
  @NonNull
  public final ImageView backgroundImgLed;

  @NonNull
  public final ImageView backgroundImgPump;

  @NonNull
  public final ImageView backgroundImgVentilator;

  @NonNull
  public final TextView controlTitle;

  @NonNull
  public final Switch switchLed;

  @NonNull
  public final Switch switchPump;

  @NonNull
  public final Switch switchVentilator;

  protected FragmentControlFarmBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView backgroundImgLed, ImageView backgroundImgPump, ImageView backgroundImgVentilator,
      TextView controlTitle, Switch switchLed, Switch switchPump, Switch switchVentilator) {
    super(_bindingComponent, _root, _localFieldCount);
    this.backgroundImgLed = backgroundImgLed;
    this.backgroundImgPump = backgroundImgPump;
    this.backgroundImgVentilator = backgroundImgVentilator;
    this.controlTitle = controlTitle;
    this.switchLed = switchLed;
    this.switchPump = switchPump;
    this.switchVentilator = switchVentilator;
  }

  @NonNull
  public static FragmentControlFarmBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_control_farm, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentControlFarmBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentControlFarmBinding>inflateInternal(inflater, R.layout.fragment_control_farm, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentControlFarmBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_control_farm, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentControlFarmBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentControlFarmBinding>inflateInternal(inflater, R.layout.fragment_control_farm, null, false, component);
  }

  public static FragmentControlFarmBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentControlFarmBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentControlFarmBinding)bind(component, view, R.layout.fragment_control_farm);
  }
}
