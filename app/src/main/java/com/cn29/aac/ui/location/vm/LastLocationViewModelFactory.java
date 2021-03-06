package com.cn29.aac.ui.location.vm;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import com.cn29.aac.repo.itunes.ItunesRepository;
import com.cn29.aac.repo.location.LastLocationListener;
import javax.inject.Inject;


/**
 * Created by Charles Ng on 20/9/2017.
 */

public class LastLocationViewModelFactory extends ViewModelProvider.NewInstanceFactory{
  private LastLocationListener lastLocationListener;
  private ItunesRepository itunesRepository;

  @Inject
  public LastLocationViewModelFactory(LastLocationListener lastLocationListener,
      ItunesRepository itunesRepository) {
    this.lastLocationListener = lastLocationListener;
    this.itunesRepository = itunesRepository;
  }

  @Override
  public <T extends ViewModel> T create(Class<T> modelClass) {
    return (T) new LastLocationViewModel(lastLocationListener, itunesRepository);
  }
}
