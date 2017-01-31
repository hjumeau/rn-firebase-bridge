package com.davecoates.rnfirebasebridge;

import com.facebook.react.bridge.*;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;

/**
 * Created by hjumeau on 31/01/2017.
 */

public class FirebaseBridgeEmailPasswordAuthProvider extends ReactContextBaseJavaModule {

    public FirebaseBridgeEmailPasswordAuthProvider(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "FirebaseBridgeEmailPasswordAuthProvider";
    }

    @ReactMethod
    public void credential(String email, String password, Promise promise) {
        AuthCredential credential = EmailAuthProvider.getCredential(email, password);
        WritableMap data = Arguments.createMap();
        data.putString("id", FirebaseBridgeCredentialCache.addCredential(credential));
        data.putString("provider", credential.getProvider());
        promise.resolve(data);
    }
}
