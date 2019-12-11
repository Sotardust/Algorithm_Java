package com.dai.encypt;



public interface BinaryEncoder extends Encoder {
    byte[] encode(byte[] var1) throws EncoderException;
}
