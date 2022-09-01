// Generated by data binding compiler. Do not edit!
package kr.hs.dgsw.campus.smartfarm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import java.lang.Deprecated;
import java.lang.Object;
import kr.hs.dgsw.campus.smartfarm.R;

public abstract class ActivityMainBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout bottomLayout;

  @NonNull
  public final ConstraintLayout changeBtn;

  @NonNull
  public final ImageView changeImg;

  @NonNull
  public final AppCompatButton confirmBtn;

  @NonNull
  public final ConstraintLayout drawer;

  @NonNull
  public final TextView farmTitle;

  @NonNull
  public final LinearLayout lettuceLayout;

  @NonNull
  public final SlidingUpPanelLayout mainFrame;

  @NonNull
  public final LinearLayout napaCabbageLayout;

  @NonNull
  public final TextView selectTitle;

  @NonNull
  public final LinearLayout tomatoLayout;

  @NonNull
  public final LinearLayout topLayout;

  @NonNull
  public final LinearLayout vegetableLayout;

  protected ActivityMainBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout bottomLayout, ConstraintLayout changeBtn, ImageView changeImg,
      AppCompatButton confirmBtn, ConstraintLayout drawer, TextView farmTitle,
      LinearLayout lettuceLayout, SlidingUpPanelLayout mainFrame, LinearLayout napaCabbageLayout,
      TextView selectTitle, LinearLayout tomatoLayout, LinearLayout topLayout,
      LinearLayout vegetableLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomLayout = bottomLayout;
    this.changeBtn = changeBtn;
    this.changeImg = changeImg;
    this.confirmBtn = confirmBtn;
    this.drawer = drawer;
    this.farmTitle = farmTitle;
    this.lettuceLayout = lettuceLayout;
    this.mainFrame = mainFrame;
    this.napaCabbageLayout = napaCabbageLayout;
    this.selectTitle = selectTitle;
    this.tomatoLayout = tomatoLayout;
    this.topLayout = topLayout;
    this.vegetableLayout = vegetableLayout;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_main, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMainBinding>inflateInternal(inflater, R.layout.activity_main, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_main, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMainBinding>inflateInternal(inflater, R.layout.activity_main, null, false, component);
  }

  public static ActivityMainBinding bind(@NonNull View view) {
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
  public static ActivityMainBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityMainBinding)bind(component, view, R.layout.activity_main);
  }
}