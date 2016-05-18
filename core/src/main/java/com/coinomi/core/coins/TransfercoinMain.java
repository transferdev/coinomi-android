package com.coinomi.core.coins;

import com.coinomi.core.coins.families.PeerFamily;

/**
 * @author John L. Jegutanis
 */
public class TransfercoinMain extends PeerFamily {
    private TransfercoinMain() {
        id = "transfercoin.main";

        addressHeader = 66;
        p2shHeader = 85;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 500;
        dumpedPrivateKeyHeader = 239;

        name = "Transfercoin";
        symbol = "TX";
        uriScheme = "transfercoin"; // TODO verify, could be ppcoin?
        bip44Index = 92;
        unitExponent = 8;
        feeValue = value(10000); // 0.01TX, careful Transfercoin has 1000000 units per coin
        minNonDust = value(10000); // 0.01TX
        softDustLimit = minNonDust;
        softDustPolicy = SoftDustPolicy.NO_POLICY;
        signedMessageHeader = toBytes("TransferCoin Signed Message:\n");
    }

    private static TransfercoinMain instance = new TransfercoinMain();
    public static synchronized CoinType get() {
        return instance;
    }
}
