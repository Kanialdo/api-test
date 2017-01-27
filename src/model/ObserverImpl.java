package model;

import broadcast.impl.ContactObserver;
import broadcast.impl.TransactionObserver;
import utils.SupportedId;

public class ObserverImpl implements ContactObserver, TransactionObserver {

    @Override
    public void itemUpdated() {

    }

    @Override
    public SupportedId<String> getContactSupportedId() {
        return new SupportedId<>("1");
    }

    @Override
    public SupportedId<String> getTransactionSupportedId() {
        return new SupportedId<>("2");
    }

    @Override
    public void onTransactionUpdated() {

    }

}
