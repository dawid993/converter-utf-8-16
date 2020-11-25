package com.david.utfconverter;

import com.david.utfconverter.converters.ConvertToUtf8;
import com.david.utfconverter.converters.DecodeFromUtf16;

public class Converter {

    public static void main(String[] args) {
        int codePointUTF_16 = 0b11011000001111011101110010101111;
        System.out.println(new String(new Converter().convertFromUtf16ToUtf8(codePointUTF_16)));
    }

    public byte[] convertFromUtf16ToUtf8(int utf16Encoded) {
        return new ConvertToUtf8().encodeUTF_8(
                new DecodeFromUtf16().decodeUTF_16(utf16Encoded)
        );
    }
}
