package com.dager.mvpdagger2retrofitroomrxjava.ui.root;



public interface BaseContract {

    interface View {

    }

    interface Presenter {

        void setView(View view);


        void dropView();
    }

    interface Model {

    }

}