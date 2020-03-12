package com.example.robodoc.domain.menu_module;

import android.content.Context;

import com.example.robodoc.domain.db.Database;
import com.example.robodoc.domain.db.repository.BloodRepository;
import com.example.robodoc.models.Blood;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuPresenter {

    private MenuView menuView;
    private BloodRepository bloodRepository;

    public MenuPresenter(MenuView menuView, Context context) {
        bloodRepository = new BloodRepository(context);
        this.menuView = menuView;
    }

    public void transferActivity(Class transferClass) {
        menuView.transferActivity(transferClass);
    }

    public void initDatabase() {

        bloodRepository.initBloodObjects();
    }

    public List<Blood> getBlood(){
        return bloodRepository.getAll();
    }


}
