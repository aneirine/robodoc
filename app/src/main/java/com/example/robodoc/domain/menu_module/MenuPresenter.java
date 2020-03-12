package com.example.robodoc.domain.menu_module;

import com.example.robodoc.domain.db.dao.BloodDao;
import com.example.robodoc.domain.db.repository.BloodRepository;

public class MenuPresenter {

    private MenuView menuView;
    private BloodRepository bloodRepository;

    public MenuPresenter(MenuView menuView) {
        this.menuView = menuView;
    }

    public void transferActivity(Class transferClass) {
        menuView.transferActivity(transferClass);
    }
}
