package com.example.robodoc.menu;

public class MenuPresenter {

    private MenuView menuView;

    public MenuPresenter(MenuView menuView) {
        this.menuView = menuView;
    }

    public void activityTransfer(Class transferClass){
        menuView.transferActivity(transferClass);
    }
}
