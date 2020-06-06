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


public class File implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static class CHOICE implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		public byte[] code = null;
		public BerNull doNotCreate = null;
		public Fcp fileDescriptor = null;
		public UInt16 fillFileOffset = null;
		public BerOctetString fillFileContent = null;
		
		public CHOICE() {
		}

		public CHOICE(byte[] code) {
			this.code = code;
		}

		public CHOICE(BerNull doNotCreate, Fcp fileDescriptor, UInt16 fillFileOffset, BerOctetString fillFileContent) {
			this.doNotCreate = doNotCreate;
			this.fileDescriptor = fileDescriptor;
			this.fillFileOffset = fillFileOffset;
			this.fillFileContent = fillFileContent;
		}

		public int encode(OutputStream reverseOS) throws IOException {

			if (code != null) {
				for (int i = code.length - 1; i >= 0; i--) {
					reverseOS.write(code[i]);
				}
				return code.length;
			}

			int codeLength = 0;
			if (fillFileContent != null) {
				codeLength += fillFileContent.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 3
				reverseOS.write(0x83);
				codeLength += 1;
				return codeLength;
			}
			
			if (fillFileOffset != null) {
				codeLength += fillFileOffset.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 2
				reverseOS.write(0x82);
				codeLength += 1;
				return codeLength;
			}
			
			if (fileDescriptor != null) {
				codeLength += fileDescriptor.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 1
				reverseOS.write(0xA1);
				codeLength += 1;
				return codeLength;
			}
			
			if (doNotCreate != null) {
				codeLength += doNotCreate.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 0
				reverseOS.write(0x80);
				codeLength += 1;
				return codeLength;
			}
			
			throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
		}

		public int decode(InputStream is) throws IOException {
			return decode(is, null);
		}

		public int decode(InputStream is, BerTag berTag) throws IOException {

			int tlvByteCount = 0;
			boolean tagWasPassed = (berTag != null);

			if (berTag == null) {
				berTag = new BerTag();
				tlvByteCount += berTag.decode(is);
			}

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 0)) {
				doNotCreate = new BerNull();
				tlvByteCount += doNotCreate.decode(is, false);
				return tlvByteCount;
			}

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
				fileDescriptor = new Fcp();
				tlvByteCount += fileDescriptor.decode(is, false);
				return tlvByteCount;
			}

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
				fillFileOffset = new UInt16();
				tlvByteCount += fillFileOffset.decode(is, false);
				return tlvByteCount;
			}

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 3)) {
				fillFileContent = new BerOctetString();
				tlvByteCount += fillFileContent.decode(is, false);
				return tlvByteCount;
			}

			if (tagWasPassed) {
				return 0;
			}

			throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
		}

		public void encodeAndSave(int encodingSizeGuess) throws IOException {
			ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
			encode(reverseOS);
			code = reverseOS.getArray();
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			appendAsString(sb, 0);
			return sb.toString();
		}

		public void appendAsString(StringBuilder sb, int indentLevel) {

			if (doNotCreate != null) {
				sb.append("doNotCreate: ").append(doNotCreate);
				return;
			}

			if (fileDescriptor != null) {
				sb.append("fileDescriptor: ");
				fileDescriptor.appendAsString(sb, indentLevel + 1);
				return;
			}

			if (fillFileOffset != null) {
				sb.append("fillFileOffset: ").append(fillFileOffset);
				return;
			}

			if (fillFileContent != null) {
				sb.append("fillFileContent: ").append(fillFileContent);
				return;
			}

			sb.append("<none>");
		}

	}

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
	public byte[] code = null;
	public List<CHOICE> seqOf = null;

	public File() {
		seqOf = new ArrayList<CHOICE>();
	}

	public File(byte[] code) {
		this.code = code;
	}

	public File(List<CHOICE> seqOf) {
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
			codeLength += seqOf.get(i).encode(reverseOS);
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

				CHOICE element = new CHOICE();
				vByteCount += element.decode(is, berTag);
				seqOf.add(element);
			}
		}
		while (vByteCount < lengthVal) {
			CHOICE element = new CHOICE();
			vByteCount += element.decode(is, null);
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
			Iterator<CHOICE> it = seqOf.iterator();
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

