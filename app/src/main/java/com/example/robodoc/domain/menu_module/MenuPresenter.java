package com.example.robodoc.domain.menu_module;

public class MenuPresenter {

    private MenuView menuView;

    public MenuPresenter(MenuView menuView) {
        this.menuView = menuView;
    }

    public void transferActivity(Class transferClass){
        menuView.transferActivity(transferClass);
    }
}
