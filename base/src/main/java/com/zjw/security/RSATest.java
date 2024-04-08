package com.zjw.security;

import java.security.*;
import java.util.Base64;

/**
 * @author 朱俊伟
 * @since 2024/04/07 22:51
 */
public class RSATest {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        // 生成密钥对
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // 获取公钥和私钥
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // 待签名的内容（示例中为空）
        byte[] content = "Hello".getBytes();

        // 创建 Signature 对象，并指定使用私钥进行签名
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);

        // 签名流程
        signature.update(content); // 更新要签名的内容
        byte[] signatureBytes = signature.sign(); // 生成签名字节码

        // 将签名字节码转换为Base64编码并打印
        String signatureBase64 = Base64.getEncoder().encodeToString(signatureBytes);
        System.out.println("签名字节码（Base64编码）: " + signatureBase64);

        // 创建另一个 Signature 对象，并指定使用公钥进行验签
        Signature verifier = Signature.getInstance("SHA256withRSA");
        verifier.initVerify(publicKey);

        // 验签流程
        verifier.update(content); // 更新要验签的内容
        boolean valid = verifier.verify(signatureBytes); // 进行验签，返回验签结果

        // 输出签名结果
        if (valid) {
            System.out.println("签名验证成功");
        } else {
            System.out.println("签名验证失败");
        }

    }
}
