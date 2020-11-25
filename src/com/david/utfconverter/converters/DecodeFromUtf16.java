package com.david.utfconverter.converters;

public class DecodeFromUtf16 {

    public int decodeUTF_16(final int encodedSign){
        if((encodedSign >= 0x0000 && encodedSign <= 0xD7FF) || (encodedSign >= 0xE000 && encodedSign <= 0xFFFF)){
            return encodedSign;
        }

        final int higherBits = extractHigherBits(encodedSign);
        final int loweBits = extractLowerBits(encodedSign);

        int finalCode = (higherBits & 0x3ff) << 10;
        finalCode |= loweBits & 0x3ff;
        finalCode += 0x10000;

        return finalCode;
    }

    private int extractHigherBits(int encodedSign) {
        return (encodedSign & 0xFFFF0000) >> 16;
    }

    private int extractLowerBits(int encodedSign) {
        return encodedSign & 0xffff;
    }
}
