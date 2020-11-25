package com.david.utfconverter.converters;

public class ConvertToUtf8 {

    public byte[] encodeUTF_8(int code){
        int byteNumber = getNumberOfBites(code);
        int firstByte = calculateFirstByte(byteNumber);

        byte arr[] = new byte[byteNumber];

        for(int i = byteNumber - 1; i > 0; i--){
            int currentByte = 0x2 << 6;
            currentByte =  currentByte | code & ((1 << 6) - 1);
            code = code >> 6;
            arr[i] = (byte) currentByte;
        }

        arr[0] = (byte)(firstByte | code);

        return arr;

    }

    private int getNumberOfBites(int code){
        return code <= 0x7F ? 1 : code <= 0x7FF ? 2 : code <= 0xFFFF ? 3 : code <= 0x1FFFFF
                ? 4 : code <= 0x3FFFFFF ? 5 : 6;
    }

    private int calculateFirstByte(int byteNumber){
        int firstByte = 0;

        for(int i = 1; i <= byteNumber; i++){
            firstByte = (firstByte | 1) << 1;
        }

        firstByte = (firstByte << (8 - byteNumber - 1));

        return firstByte;
    }
}
