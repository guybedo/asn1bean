/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.rspdefinitions;

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

import com.beanit.jasn1.compiler.pkix1explicit88.Certificate;
import com.beanit.jasn1.compiler.pkix1explicit88.CertificateList;
import com.beanit.jasn1.compiler.pkix1explicit88.Time;
import com.beanit.jasn1.compiler.pkix1implicit88.SubjectKeyIdentifier;

public class ProfilePolicyAuthorisationRule implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static class AllowedOperators implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
		public byte[] code = null;
		public List<OperatorId> seqOf = null;

		public AllowedOperators() {
			seqOf = new ArrayList<OperatorId>();
		}

		public AllowedOperators(byte[] code) {
			this.code = code;
		}

		public AllowedOperators(List<OperatorId> seqOf) {
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

			while (vByteCount < lengthVal || lengthVal < 0) {
				vByteCount += berTag.decode(is);

				if (lengthVal < 0 && berTag.equals(0, 0, 0)) {
					vByteCount += BerLength.readEocByte(is);
					break;
				}

				if (!berTag.equals(OperatorId.tag)) {
					throw new IOException("Tag does not match mandatory sequence of/set of component.");
				}
				OperatorId element = new OperatorId();
				vByteCount += element.decode(is, false);
				seqOf.add(element);
			}
			if (lengthVal >= 0 && vByteCount != lengthVal) {
				throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected " + lengthVal + " but has " + vByteCount);

			}
			return tlByteCount + vByteCount;
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
				Iterator<OperatorId> it = seqOf.iterator();
				if (it.hasNext()) {
					it.next().appendAsString(sb, indentLevel + 1);
					while (it.hasNext()) {
						sb.append(",\n");
						for (int i = 0; i < indentLevel + 1; i++) {
							sb.append("\t");
						}
						it.next().appendAsString(sb, indentLevel + 1);
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

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	public PprIds pprIds = null;
	public AllowedOperators allowedOperators = null;
	public BerBitString pprFlags = null;
	
	public ProfilePolicyAuthorisationRule() {
	}

	public ProfilePolicyAuthorisationRule(byte[] code) {
		this.code = code;
	}

	public ProfilePolicyAuthorisationRule(PprIds pprIds, AllowedOperators allowedOperators, BerBitString pprFlags) {
		this.pprIds = pprIds;
		this.allowedOperators = allowedOperators;
		this.pprFlags = pprFlags;
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
		codeLength += pprFlags.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 2
		reverseOS.write(0x82);
		codeLength += 1;
		
		codeLength += allowedOperators.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 1
		reverseOS.write(0xA1);
		codeLength += 1;
		
		codeLength += pprIds.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 0
		reverseOS.write(0x80);
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

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 0)) {
			pprIds = new PprIds();
			vByteCount += pprIds.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
			allowedOperators = new AllowedOperators();
			vByteCount += allowedOperators.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
			pprFlags = new BerBitString();
			vByteCount += pprFlags.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (lengthVal < 0) {
			if (!berTag.equals(0, 0, 0)) {
				throw new IOException("Decoded sequence has wrong end of contents octets");
			}
			vByteCount += BerLength.readEocByte(is);
			return tlByteCount + vByteCount;
		}

		throw new IOException("Unexpected end of sequence, length tag: " + lengthVal + ", bytes decoded: " + vByteCount);

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
		if (pprIds != null) {
			sb.append("pprIds: ").append(pprIds);
		}
		else {
			sb.append("pprIds: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (allowedOperators != null) {
			sb.append("allowedOperators: ");
			allowedOperators.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("allowedOperators: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (pprFlags != null) {
			sb.append("pprFlags: ").append(pprFlags);
		}
		else {
			sb.append("pprFlags: <empty-required-field>");
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

