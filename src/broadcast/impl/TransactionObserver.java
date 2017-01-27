package broadcast.impl;

import broadcast.FilterableBroadcastObserver;
import model.Transaction;
import utils.SupportedId;

public interface TransactionObserver extends FilterableBroadcastObserver {

    void onTransactionChanged(Transaction transaction);

    void onTransactionProcessChanged(String id, float progress, Object status);

    SupportedId<String> getTransactionSupportedId();

}
