package com.example.mvvm_example;

import android.view.View;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import java.util.Observable;

public class UserVM extends Observable {

	public ObservableField<String> name;
	//private model model;

	public ObservableInt getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(ObservableInt isVisible) {
		this.isVisible = isVisible;
	}

	public ObservableInt isVisible;

	public ObservableField<String> getName() {
		return name;
	}

	public UserVM() {
		//model = new model();
		isVisible= new ObservableInt(View.GONE);
	}

	public void setName(ObservableField<String> name) {

		this.name = name;
	}

	public void onButtonClick() {
		isVisible.set(View.VISIBLE);
		setIsVisible(isVisible);
		//se cambia por new model ya que como el model contiene un hilo, al intentar dispararlo mas de una vez crasheara.
		new model().execute("http://cardfindercdmx.com/personal/get_book.php",new model.OnResult() {

			@Override
			public void onSuccess(String result) {
				name.set(result);
				isVisible.set(View.GONE);
				setIsVisible(isVisible);
			}

			@Override
			public void onError(String error) {
				isVisible.set(View.GONE);
				setIsVisible(isVisible);
			}
		});
	}

}
