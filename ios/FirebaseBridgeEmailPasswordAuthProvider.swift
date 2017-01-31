//
//  FirebaseBridgeEmailPasswordAuthProvider.swift
//  ChenBoul
//
//  Created by Harry JUMEAU on 31/01/2017.
//  Copyright © 2017 Facebook. All rights reserved.
//

import Firebase

@objc(FirebaseBridgeEmailPasswordAuthProvider)
class FirebaseBridgeEmailPasswordAuthProvider : NSObject {
  
  var bridge: RCTBridge!
  
  override init() {
    super.init()
  }
  
  @objc func credential(email:String, password:String, resolver resolve: RCTPromiseResolveBlock, rejecter reject: RCTPromiseRejectBlock) {
    let credential = FIREmailPasswordAuthProvider.credentialWithEmail(email, password: password)
    resolve([
      "id": FirebaseBridgeCredentialCache.addCredential(credential),
      "provider": credential.provider,
      ])
  }
}
