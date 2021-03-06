package com.cn29.aac.ui.main.vm;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.SharedPreferences;
import javax.inject.Inject;

/**
 * Created by Charles Ng on 13/10/2017.
 */

public class AppArchNavViewModelFactory extends ViewModelProvider.NewInstanceFactory {

  private SharedPreferences sharedPreferences;

  @Inject
  public AppArchNavViewModelFactory(SharedPreferences sharedPreferences) {
    this.sharedPreferences = sharedPreferences;
  }

  @Override
  public <T extends ViewModel> T create(Class<T> modelClass) {
    return (T) new AppArchNavViewModel(sharedPreferences);
  }
}
