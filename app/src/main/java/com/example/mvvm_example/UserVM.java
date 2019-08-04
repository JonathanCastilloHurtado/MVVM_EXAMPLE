package com.example.mvvm_example;

import androidx.databinding.ObservableField;

import java.util.Observable;

public class UserVM extends Observable {

	public ObservableField<String> name;
	private model model;

	public ObservableField<String> getName() {
		return name;
	}

	public UserVM() {
		model = new model();
	}

	public void setName(ObservableField<String> name) {

		this.name = name;
	}

	public void onButtonClick() {
		//aqui es el problema ya que pasa lo mismo que cuando se implemente mal el MVP
		model.getBook(new model.OnResult() {

			@Override
			public void onSuccess(String result) {
				name.set(result);
			}

			@Override
			public void onError() {

			}
		});
	}
}
