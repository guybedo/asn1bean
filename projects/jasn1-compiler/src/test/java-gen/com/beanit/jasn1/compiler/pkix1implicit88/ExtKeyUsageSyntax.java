/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.pkix1implicit88;

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

import com.beanit.jasn1.compiler.pkix1explicit88.Attribute;
import com.beanit.jasn1.compiler.pkix1explicit88.CertificateSerialNumber;
import com.beanit.jasn1.compiler.pkix1explicit88.DirectoryString;
import com.beanit.jasn1.compiler.pkix1explicit88.Name;
import com.beanit.jasn1.compiler.pkix1explicit88.ORAddress;
import com.beanit.jasn1.compiler.pkix1explicit88.RelativeDistinguishedName;

public class ExtKeyUsageSyntax implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
	public byte[] code = null;
	public List<KeyPurposeId> seqOf = null;

	public ExtKeyUsageSyntax() {
		seqOf = new ArrayList<KeyPurposeId>();
	}

	public ExtKeyUsageSyntax(byte[] code) {
		this.code = code;
	}

	public ExtKeyUsageSyntax(List<KeyPurposeId> seqOf) {
		this.seqOf = seqOf;
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
		for (int i = (seqOf.size() - 1); i >= 0; i--) {
			codeLength += seqOf.get(i).encode(reverseOS, true);
		}

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

		if (length.val == -1) {
			while (true) {
				vByteCount += berTag.decode(is);

				if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
					int nextByte = is.read();
					if (nextByte != 0) {
						if (nextByte == -1) {
							throw new EOFException("Unexpected end of input stream.");
						}
						throw new IOException("Decoded sequence has wrong end of contents octets");
					}
					tlByteCount += vByteCount + 1;
					return tlByteCount;
				}

				KeyPurposeId element = new KeyPurposeId();
				vByteCount += element.decode(is, false);
				seqOf.add(element);
			}
		}
		while (vByteCount < lengthVal) {
			KeyPurposeId element = new KeyPurposeId();
			vByteCount += element.decode(is, true);
			seqOf.add(element);
		}
		if (vByteCount != lengthVal) {
			throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected " + lengthVal + " but has " + vByteCount);

		}
		tlByteCount += vByteCount;

		return tlByteCount;
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

		sb.append("{\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (seqOf == null) {
			sb.append("null");
		}
		else {
			Iterator<KeyPurposeId> it = seqOf.iterator();
			if (it.hasNext()) {
				sb.append(it.next());
				while (it.hasNext()) {
					sb.append(",\n");
					for (int i = 0; i < indentLevel + 1; i++) {
						sb.append("\t");
					}
					sb.append(it.next());
				}
			}
		}

		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

