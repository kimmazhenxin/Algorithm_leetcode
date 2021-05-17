package com.algorithm.string;

/**
 * leetcode 1108.IP地址无效化
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 * 示例
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 *
 * 解题思路:
 *  简单字符串替换
 *
 * @Author: kim
 * @Description:IP地址无效化
 * @Date: 9:01 2021/4/8
 * @Version: 1.0
 */
public class IpAddress_1108 {

    public static void main(String[] args) {
        String address = "1.1.1.1";
        System.out.println(invalidIpAddress(address));

    }


    public static String invalidIpAddress(String address) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                str.append("[.]");
            } else {
                str.append(address.charAt(i));
            }
        }
        return str.toString();
    }






}
