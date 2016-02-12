"use strict";
var exec = require('cordova/exec');

function bluetoothPrinter() {
}

bluetoothPrinter.prototype.findMac = function (successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "CCMBluetooth", "findMac", []);
};

bluetoothPrinter.install = function () {
    if (!window.plugins) {
        window.plugins = {};
    }

    window.plugins.bluetoothPrinter = new bluetoothPrinter();
    return window.plugins.bluetoothPrinter;
};

cordova.addConstructor(bluetoothPrinter.install);