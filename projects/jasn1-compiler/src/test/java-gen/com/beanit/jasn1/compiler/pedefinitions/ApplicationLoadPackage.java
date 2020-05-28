/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.pedefinitions;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.jasn1.ber.*;
import com.beanit.jasn1.ber.types.*;
import com.beanit.jasn1.ber.types.string.*;


public class ApplicationLoadPackage implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	public ApplicationIdentifier loadPackageAID = null;
	public ApplicationIdentifier securityDomainAID = null;
	public BerOctetString nonVolatileCodeLimitC6 = null;
	public BerOctetString volatileDataLimitC7 = null;
	public BerOctetString nonVolatileDataLimitC8 = null;
	public BerOctetString hashValue = null;
	public BerOctetString loadBlockObject = null;
	
	public ApplicationLoadPackage() {
	}

	public ApplicationLoadPackage(byte[] code) {
		this.code = code;
	}

	public ApplicationLoadPackage(ApplicationIdentifier loadPackageAID, ApplicationIdentifier securityDomainAID, BerOctetString nonVolatileCodeLimitC6, BerOctetString volatileDataLimitC7, BerOctetString nonVolatileDataLimitC8, BerOctetString hashValue, BerOctetString loadBlockObject) {
		this.loadPackageAID = loadPackageAID;
		this.securityDomainAID = securityDomainAID;
		this.nonVolatileCodeLimitC6 = nonVolatileCodeLimitC6;
		this.volatileDataLimitC7 = volatileDataLimitC7;
		this.nonVolatileDataLimitC8 = nonVolatileDataLimitC8;
		this.hashValue = hashValue;
		this.loadBlockObject = loadBlockObject;
	}

	public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		codeLength += loadBlockObject.encode(reverseOS, false);
		// write tag: PRIVATE_CLASS, PRIMITIVE, 4
		reverseOS.write(0xC4);
		codeLength += 1;
		
		if (hashValue != null) {
			codeLength += hashValue.encode(reverseOS, false);
			// write tag: PRIVATE_CLASS, PRIMITIVE, 1
			reverseOS.write(0xC1);
			codeLength += 1;
		}
		
		if (nonVolatileDataLimitC8 != null) {
			codeLength += nonVolatileDataLimitC8.encode(reverseOS, false);
			// write tag: PRIVATE_CLASS, PRIMITIVE, 8
			reverseOS.write(0xC8);
			codeLength += 1;
		}
		
		if (volatileDataLimitC7 != null) {
			codeLength += volatileDataLimitC7.encode(reverseOS, false);
			// write tag: PRIVATE_CLASS, PRIMITIVE, 7
			reverseOS.write(0xC7);
			codeLength += 1;
		}
		
		if (nonVolatileCodeLimitC6 != null) {
			codeLength += nonVolatileCodeLimitC6.encode(reverseOS, false);
			// write tag: PRIVATE_CLASS, PRIMITIVE, 6
			reverseOS.write(0xC6);
			codeLength += 1;
		}
		
		if (securityDomainAID != null) {
			codeLength += securityDomainAID.encode(reverseOS, false);
			// write tag: APPLICATION_CLASS, PRIMITIVE, 15
			reverseOS.write(0x4F);
			codeLength += 1;
		}
		
		codeLength += loadPackageAID.encode(reverseOS, false);
		// write tag: APPLICATION_CLASS, PRIMITIVE, 15
		reverseOS.write(0x4F);
		codeLength += 1;
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int tlByteCount = 0;
		int vByteCount = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			tlByteCount += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		tlByteCount += length.decode(is);

		int lengthVal = length.val;
		vByteCount += berTag.decode(is);
		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 15)) {
			loadPackageAID = new ApplicationIdentifier();
			vByteCount += loadPackageAID.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 15)) {
			securityDomainAID = new ApplicationIdentifier();
			vByteCount += securityDomainAID.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.PRIVATE_CLASS, BerTag.PRIMITIVE, 6)) {
			nonVolatileCodeLimitC6 = new BerOctetString();
			vByteCount += nonVolatileCodeLimitC6.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.PRIVATE_CLASS, BerTag.PRIMITIVE, 7)) {
			volatileDataLimitC7 = new BerOctetString();
			vByteCount += volatileDataLimitC7.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.PRIVATE_CLASS, BerTag.PRIMITIVE, 8)) {
			nonVolatileDataLimitC8 = new BerOctetString();
			vByteCount += nonVolatileDataLimitC8.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.PRIVATE_CLASS, BerTag.PRIMITIVE, 1)) {
			hashValue = new BerOctetString();
			vByteCount += hashValue.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.PRIVATE_CLASS, BerTag.PRIMITIVE, 4)) {
			loadBlockObject = new BerOctetString();
			vByteCount += loadBlockObject.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (lengthVal < 0) {
			if (!berTag.equals(0, 0, 0)) {
				throw new IOException("Decoded sequence has wrong end of contents octets");
			}
			int lastByte = is.read();
			if (lastByte == -1) {
				throw new EOFException();
			}
			if (lastByte != 0) {
				throw new IOException("Decoded sequence has wrong end of contents octets");
			}
			return tlByteCount + vByteCount + 1;
		}

		throw new IOException("Unexpected end of sequence, length tag: " + lengthVal + ", actual sequence length: " + vByteCount);

	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		sb.append("\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (loadPackageAID != null) {
			sb.append("loadPackageAID: ").append(loadPackageAID);
		}
		else {
			sb.append("loadPackageAID: <empty-required-field>");
		}
		
		if (securityDomainAID != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("securityDomainAID: ").append(securityDomainAID);
		}
		
		if (nonVolatileCodeLimitC6 != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("nonVolatileCodeLimitC6: ").append(nonVolatileCodeLimitC6);
		}
		
		if (volatileDataLimitC7 != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("volatileDataLimitC7: ").append(volatileDataLimitC7);
		}
		
		if (nonVolatileDataLimitC8 != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("nonVolatileDataLimitC8: ").append(nonVolatileDataLimitC8);
		}
		
		if (hashValue != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("hashValue: ").append(hashValue);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (loadBlockObject != null) {
			sb.append("loadBlockObject: ").append(loadBlockObject);
		}
		else {
			sb.append("loadBlockObject: <empty-required-field>");
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

