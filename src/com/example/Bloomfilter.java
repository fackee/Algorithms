package com.example


import java.util.BitSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Bloomfliter 简易Demo
 * @author zhujianxin
 * @date 2018/7/13.
 */
public class BloomFilter {

    private BitSet bitSet;

    private int hashFunctionCount;

    private int maxBitsetLength;

    private int maxKeyCount;

    private double falsePositive;

    /**
     * 一般来说，我们要实现一个bloomfilter,需要接收两个参数，即我们应用需要的容错率以及我们要存储的最大容量。
     * @param falsePositive 容错率
     * @param maxKeyCount 最大容量
     */
    public BloomFilter(double falsePositive,int maxKeyCount){
        this.falsePositive = falsePositive;
        this.maxKeyCount = maxKeyCount;
        this.maxBitsetLength = caculateBitsetLength();
        this.hashFunctionCount = calculateHashFunctionCount();
        this.bitSet = new BitSet(maxBitsetLength);
    }

    /**
     * 计算bit数组最大位数
     * bit数组最大位数 = 最大存储数据*ln(容错率)／ln(0.6185)
     */
    public int caculateBitsetLength(){
        return (int) (maxKeyCount / (Math.log(0.6185D)/Math.log(falsePositive)));
    }

    /**
     * 计算k个不同的hash函数
     * k个hash函数 = -ln(容错率)／ln(2)
     */
    public int calculateHashFunctionCount(){
        return (int)(-Math.log(falsePositive) / Math.log(2));
    }

    public void add(String key){
        for(int i=0;i<hashFunctionCount;i++){
            int offset = getHashCode(key,i);
            bitSet.set(offset);
        }
    }


    /**
     *简单hash函数
     */
    public int getHashCode(String key,int index){
        return Math.abs(key.hashCode() / (index+1));
    }

    public boolean include(String key){

        for(int i=0;i<hashFunctionCount;i++){
            int offset = getHashCode(key,i);
            if(!bitSet.get(offset)){
                return false;
            }
        }
        return true;
    }

    public BitSet getBitSet() {
        return bitSet;
    }

    public BloomFilter setBitSet(BitSet bitSet) {
        this.bitSet = bitSet;
        return this;
    }

    public int getHashFunctionCount() {
        return hashFunctionCount;
    }

    public BloomFilter setHashFunctionCount(int hashFunctionCount) {
        this.hashFunctionCount = hashFunctionCount;
        return this;
    }

    public int getMaxBitsetLength() {
        return maxBitsetLength;
    }

    public BloomFilter setMaxBitsetLength(int maxBitsetLength) {
        this.maxBitsetLength = maxBitsetLength;
        return this;
    }

    public int getMaxKeyCount() {
        return maxKeyCount;
    }

    public BloomFilter setMaxKeyCount(int maxKeyCount) {
        this.maxKeyCount = maxKeyCount;
        return this;
    }

    public double getFalsePositive() {
        return falsePositive;
    }

    public BloomFilter setFalsePositive(double falsePositive) {
        this.falsePositive = falsePositive;
        return this;
    }

    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter(0.0000001,100000000);
        System.out.println(bloomFilter.getMaxBitsetLength());
        System.out.println(bloomFilter.getHashFunctionCount());
        for(int i=0;i<1000;i++){
            bloomFilter.add("test-key"+i);
        }
        for(int i=0;i<1000;i++){
            System.out.println(bloomFilter.include("test-key"+i));
        }
    }


}
