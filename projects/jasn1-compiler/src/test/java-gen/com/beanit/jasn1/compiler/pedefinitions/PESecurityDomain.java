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


public class PESecurityDomain implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static class KeyList implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
		public byte[] code = null;
		public List<KeyObject> seqOf = null;

		public KeyList() {
			seqOf = new ArrayList<KeyObject>();
		}

		public KeyList(byte[] code) {
			this.code = code;
		}

		public KeyList(List<KeyObject> seqOf) {
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
			int codeLength = 0;
			int subCodeLength = 0;
			BerTag berTag = new BerTag();
			if (withTag) {
				codeLength += tag.decodeAndCheck(is);
			}

			BerLength length = new BerLength();
			codeLength += length.decode(is);
			int totalLength = length.val;

			if (length.val == -1) {
				while (true) {
					subCodeLength += berTag.decode(is);

					if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
						int nextByte = is.read();
						if (nextByte != 0) {
							if (nextByte == -1) {
								throw new EOFException("Unexpected end of input stream.");
							}
							throw new IOException("Decoded sequence has wrong end of contents octets");
						}
						codeLength += subCodeLength + 1;
						return codeLength;
					}

					KeyObject element = new KeyObject();
					subCodeLength += element.decode(is, false);
					seqOf.add(element);
				}
			}
			while (subCodeLength < totalLength) {
				KeyObject element = new KeyObject();
				subCodeLength += element.decode(is, true);
				seqOf.add(element);
			}
			if (subCodeLength != totalLength) {
				throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected " + totalLength + " but has " + subCodeLength);

			}
			codeLength += subCodeLength;

			return codeLength;
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
				Iterator<KeyObject> it = seqOf.iterator();
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

	public static class SdPersoData implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
		public byte[] code = null;
		public List<BerOctetString> seqOf = null;

		public SdPersoData() {
			seqOf = new ArrayList<BerOctetString>();
		}

		public SdPersoData(byte[] code) {
			this.code = code;
		}

		public SdPersoData(List<BerOctetString> seqOf) {
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
			int codeLength = 0;
			int subCodeLength = 0;
			BerTag berTag = new BerTag();
			if (withTag) {
				codeLength += tag.decodeAndCheck(is);
			}

			BerLength length = new BerLength();
			codeLength += length.decode(is);
			int totalLength = length.val;

			if (length.val == -1) {
				while (true) {
					subCodeLength += berTag.decode(is);

					if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
						int nextByte = is.read();
						if (nextByte != 0) {
							if (nextByte == -1) {
								throw new EOFException("Unexpected end of input stream.");
							}
							throw new IOException("Decoded sequence has wrong end of contents octets");
						}
						codeLength += subCodeLength + 1;
						return codeLength;
					}

					BerOctetString element = new BerOctetString();
					subCodeLength += element.decode(is, false);
					seqOf.add(element);
				}
			}
			while (subCodeLength < totalLength) {
				BerOctetString element = new BerOctetString();
				subCodeLength += element.decode(is, true);
				seqOf.add(element);
			}
			if (subCodeLength != totalLength) {
				throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected " + totalLength + " but has " + subCodeLength);

			}
			codeLength += subCodeLength;

			return codeLength;
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
				Iterator<BerOctetString> it = seqOf.iterator();
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

	public static class OpenPersoData implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

		public byte[] code = null;
		public BerOctetString restrictParameter = null;
		public BerOctetString contactlessProtocolParameters = null;
		
		public OpenPersoData() {
		}

		public OpenPersoData(byte[] code) {
			this.code = code;
		}

		public OpenPersoData(BerOctetString restrictParameter, BerOctetString contactlessProtocolParameters) {
			this.restrictParameter = restrictParameter;
			this.contactlessProtocolParameters = contactlessProtocolParameters;
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
			if (contactlessProtocolParameters != null) {
				codeLength += contactlessProtocolParameters.encode(reverseOS, true);
			}
			
			if (restrictParameter != null) {
				codeLength += restrictParameter.encode(reverseOS, false);
				// write tag: PRIVATE_CLASS, PRIMITIVE, 25
				reverseOS.write(0xD9);
				codeLength += 1;
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
			if (lengthVal == 0) {
				return tlByteCount;
			}
			vByteCount += berTag.decode(is);

			if (berTag.equals(BerTag.PRIVATE_CLASS, BerTag.PRIMITIVE, 25)) {
				restrictParameter = new BerOctetString();
				vByteCount += restrictParameter.decode(is, false);
				if (lengthVal >= 0 && vByteCount == lengthVal) {
					return tlByteCount + vByteCount;
				}
				vByteCount += berTag.decode(is);
			}
			
			if (berTag.equals(BerOctetString.tag)) {
				contactlessProtocolParameters = new BerOctetString();
				vByteCount += contactlessProtocolParameters.decode(is, false);
				if (lengthVal >= 0 && vByteCount == lengthVal) {
					return tlByteCount + vByteCount;
				}
				vByteCount += berTag.decode(is);
			}
			
			if (lengthVal < 0) {
				if (!berTag.equals(0, 0, 0)) {
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				vByteCount += BerLength.readEocByte(is);
				return tlByteCount + vByteCount;
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
			boolean firstSelectedElement = true;
			if (restrictParameter != null) {
				sb.append("\n");
				for (int i = 0; i < indentLevel + 1; i++) {
					sb.append("\t");
				}
				sb.append("restrictParameter: ").append(restrictParameter);
				firstSelectedElement = false;
			}
			
			if (contactlessProtocolParameters != null) {
				if (!firstSelectedElement) {
					sb.append(",\n");
				}
				for (int i = 0; i < indentLevel + 1; i++) {
					sb.append("\t");
				}
				sb.append("contactlessProtocolParameters: ").append(contactlessProtocolParameters);
				firstSelectedElement = false;
			}
			
			sb.append("\n");
			for (int i = 0; i < indentLevel; i++) {
				sb.append("\t");
			}
			sb.append("}");
		}

	}

	public static class CatTpParameters implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

		public byte[] code = null;
		public UInt16 catTpMaxSduSize = null;
		public UInt16 catTpMaxPduSize = null;
		
		public CatTpParameters() {
		}

		public CatTpParameters(byte[] code) {
			this.code = code;
		}

		public CatTpParameters(UInt16 catTpMaxSduSize, UInt16 catTpMaxPduSize) {
			this.catTpMaxSduSize = catTpMaxSduSize;
			this.catTpMaxPduSize = catTpMaxPduSize;
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
			codeLength += catTpMaxPduSize.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			reverseOS.write(0x81);
			codeLength += 1;
			
			codeLength += catTpMaxSduSize.encode(reverseOS, false);
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
				catTpMaxSduSize = new UInt16();
				vByteCount += catTpMaxSduSize.decode(is, false);
				vByteCount += berTag.decode(is);
			}
			else {
				throw new IOException("Tag does not match mandatory sequence component.");
			}
			
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
				catTpMaxPduSize = new UInt16();
				vByteCount += catTpMaxPduSize.decode(is, false);
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
			if (catTpMaxSduSize != null) {
				sb.append("catTpMaxSduSize: ").append(catTpMaxSduSize);
			}
			else {
				sb.append("catTpMaxSduSize: <empty-required-field>");
			}
			
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			if (catTpMaxPduSize != null) {
				sb.append("catTpMaxPduSize: ").append(catTpMaxPduSize);
			}
			else {
				sb.append("catTpMaxPduSize: <empty-required-field>");
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
	public PEHeader sdHeader = null;
	public ApplicationInstance instance = null;
	public KeyList keyList = null;
	public SdPersoData sdPersoData = null;
	public OpenPersoData openPersoData = null;
	public CatTpParameters catTpParameters = null;
	
	public PESecurityDomain() {
	}

	public PESecurityDomain(byte[] code) {
		this.code = code;
	}

	public PESecurityDomain(PEHeader sdHeader, ApplicationInstance instance, KeyList keyList, SdPersoData sdPersoData, OpenPersoData openPersoData, CatTpParameters catTpParameters) {
		this.sdHeader = sdHeader;
		this.instance = instance;
		this.keyList = keyList;
		this.sdPersoData = sdPersoData;
		this.openPersoData = openPersoData;
		this.catTpParameters = catTpParameters;
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
		if (catTpParameters != null) {
			codeLength += catTpParameters.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 5
			reverseOS.write(0xA5);
			codeLength += 1;
		}
		
		if (openPersoData != null) {
			codeLength += openPersoData.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 4
			reverseOS.write(0xA4);
			codeLength += 1;
		}
		
		if (sdPersoData != null) {
			codeLength += sdPersoData.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 3
			reverseOS.write(0xA3);
			codeLength += 1;
		}
		
		if (keyList != null) {
			codeLength += keyList.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 2
			reverseOS.write(0xA2);
			codeLength += 1;
		}
		
		codeLength += instance.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 1
		reverseOS.write(0xA1);
		codeLength += 1;
		
		codeLength += sdHeader.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
		reverseOS.write(0xA0);
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

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
			sdHeader = new PEHeader();
			vByteCount += sdHeader.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
			instance = new ApplicationInstance();
			vByteCount += instance.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
			keyList = new KeyList();
			vByteCount += keyList.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 3)) {
			sdPersoData = new SdPersoData();
			vByteCount += sdPersoData.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 4)) {
			openPersoData = new OpenPersoData();
			vByteCount += openPersoData.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 5)) {
			catTpParameters = new CatTpParameters();
			vByteCount += catTpParameters.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (lengthVal < 0) {
			if (!berTag.equals(0, 0, 0)) {
				throw new IOException("Decoded sequence has wrong end of contents octets");
			}
			vByteCount += BerLength.readEocByte(is);
			return tlByteCount + vByteCount;
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
		if (sdHeader != null) {
			sb.append("sdHeader: ");
			sdHeader.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("sdHeader: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (instance != null) {
			sb.append("instance: ");
			instance.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("instance: <empty-required-field>");
		}
		
		if (keyList != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("keyList: ");
			keyList.appendAsString(sb, indentLevel + 1);
		}
		
		if (sdPersoData != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("sdPersoData: ");
			sdPersoData.appendAsString(sb, indentLevel + 1);
		}
		
		if (openPersoData != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("openPersoData: ");
			openPersoData.appendAsString(sb, indentLevel + 1);
		}
		
		if (catTpParameters != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("catTpParameters: ");
			catTpParameters.appendAsString(sb, indentLevel + 1);
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

