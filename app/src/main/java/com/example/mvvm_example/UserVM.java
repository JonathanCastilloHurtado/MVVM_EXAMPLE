package com.example.mvvm_example;

import android.view.View;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import java.util.Observable;

public class UserVM extends Observable {

	public ObservableField<String> name;
	private model model;

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
		model = new model();
		isVisible= new ObservableInt(View.GONE);
	}

	public void setName(ObservableField<String> name) {

		this.name = name;
	}

	public void onButtonClick() {
		isVisible.set(View.VISIBLE);
		setIsVisible(isVisible);
		model.getBook(new model.OnResult() {

			@Override
			public void onSuccess(String result) {
				name.set(result);
				isVisible.set(View.GONE);
				setIsVisible(isVisible);
			}

			@Override
			public void onError() {
				isVisible.set(View.GONE);
				setIsVisible(isVisible);
			}
		});
	}

}
