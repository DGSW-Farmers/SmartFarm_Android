// Generated by data binding compiler. Do not edit!
package kr.hs.dgsw.campus.smartfarm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import kr.hs.dgsw.campus.smartfarm.R;

public abstract class HistoryListItemBinding extends ViewDataBinding {
  @NonNull
  public final ImageView arrowBtn;

  @NonNull
  public final ImageView backgroundImgHumidity;

  @NonNull
  public final ImageView backgroundImgLevel;

  @NonNull
  public final ImageView backgroundImgTemperature;

  @NonNull
  public final TextView centerText;

  @NonNull
  public final TextView endText;

  @NonNull
  public final ConstraintLayout historyLayout;

  @NonNull
  public final TextView humidityTitle;

  @NonNull
  public final TextView itemEnd;

  @NonNull
  public final ImageView itemImg;

  @NonNull
  public final TextView itemStart;

  @NonNull
  public final ConstraintLayout itemStateLayout;

  @NonNull
  public final TextView itemTitle;

  @NonNull
  public final TextView levelTitle;

  @NonNull
  public final ProgressBar progressHumidity;

  @NonNull
  public final ProgressBar progressLevel;

  @NonNull
  public final ProgressBar progressTemperature;

  @NonNull
  public final TextView startText;

  @NonNull
  public final TextView temperatureTitle;

  @NonNull
  public final ConstraintLayout topLayout;

  @NonNull
  public final TextView tvHumidityValue;

  @NonNull
  public final TextView tvLevelValue;

  @NonNull
  public final TextView tvTemperatureValue;

  protected HistoryListItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView arrowBtn, ImageView backgroundImgHumidity, ImageView backgroundImgLevel,
      ImageView backgroundImgTemperature, TextView centerText, TextView endText,
      ConstraintLayout historyLayout, TextView humidityTitle, TextView itemEnd, ImageView itemImg,
      TextView itemStart, ConstraintLayout itemStateLayout, TextView itemTitle, TextView levelTitle,
      ProgressBar progressHumidity, ProgressBar progressLevel, ProgressBar progressTemperature,
      TextView startText, TextView temperatureTitle, ConstraintLayout topLayout,
      TextView tvHumidityValue, TextView tvLevelValue, TextView tvTemperatureValue) {
    super(_bindingComponent, _root, _localFieldCount);
    this.arrowBtn = arrowBtn;
    this.backgroundImgHumidity = backgroundImgHumidity;
    this.backgroundImgLevel = backgroundImgLevel;
    this.backgroundImgTemperature = backgroundImgTemperature;
    this.centerText = centerText;
    this.endText = endText;
    this.historyLayout = historyLayout;
    this.humidityTitle = humidityTitle;
    this.itemEnd = itemEnd;
    this.itemImg = itemImg;
    this.itemStart = itemStart;
    this.itemStateLayout = itemStateLayout;
    this.itemTitle = itemTitle;
    this.levelTitle = levelTitle;
    this.progressHumidity = progressHumidity;
    this.progressLevel = progressLevel;
    this.progressTemperature = progressTemperature;
    this.startText = startText;
    this.temperatureTitle = temperatureTitle;
    this.topLayout = topLayout;
    this.tvHumidityValue = tvHumidityValue;
    this.tvLevelValue = tvLevelValue;
    this.tvTemperatureValue = tvTemperatureValue;
  }

  @NonNull
  public static HistoryListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.history_list_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static HistoryListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<HistoryListItemBinding>inflateInternal(inflater, R.layout.history_list_item, root, attachToRoot, component);
  }

  @NonNull
  public static HistoryListItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.history_list_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static HistoryListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<HistoryListItemBinding>inflateInternal(inflater, R.layout.history_list_item, null, false, component);
  }

  public static HistoryListItemBinding bind(@NonNull View view) {
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
  public static HistoryListItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (HistoryListItemBinding)bind(component, view, R.layout.history_list_item);
  }
}
