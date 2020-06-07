/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.various_tests;

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


public class SequenceNameClashTest implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static class Myseqof implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
		public byte[] code = null;
		public List<com.beanit.jasn1.compiler.various_tests.UntaggedInteger> seqOf = null;

		public Myseqof() {
			seqOf = new ArrayList<com.beanit.jasn1.compiler.various_tests.UntaggedInteger>();
		}

		public Myseqof(byte[] code) {
			this.code = code;
		}

		public Myseqof(List<com.beanit.jasn1.compiler.various_tests.UntaggedInteger> seqOf) {
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

				if (!berTag.equals(com.beanit.jasn1.compiler.various_tests.UntaggedInteger.tag)) {
					throw new IOException("Tag does not match mandatory sequence of/set of component.");
				}
				com.beanit.jasn1.compiler.various_tests.UntaggedInteger element = new com.beanit.jasn1.compiler.various_tests.UntaggedInteger();
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
				Iterator<com.beanit.jasn1.compiler.various_tests.UntaggedInteger> it = seqOf.iterator();
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

	public static class UntaggedInteger implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		public byte[] code = null;
		public com.beanit.jasn1.compiler.various_tests.UntaggedInteger myInteger = null;
		public BerBoolean myBoolean = null;
		
		public UntaggedInteger() {
		}

		public UntaggedInteger(byte[] code) {
			this.code = code;
		}

		public UntaggedInteger(com.beanit.jasn1.compiler.various_tests.UntaggedInteger myInteger, BerBoolean myBoolean) {
			this.myInteger = myInteger;
			this.myBoolean = myBoolean;
		}

		public int encode(OutputStream reverseOS) throws IOException {

			if (code != null) {
				for (int i = code.length - 1; i >= 0; i--) {
					reverseOS.write(code[i]);
				}
				return code.length;
			}

			int codeLength = 0;
			int sublength;

			if (myBoolean != null) {
				sublength = myBoolean.encode(reverseOS, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(reverseOS, sublength);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 3
				reverseOS.write(0xA3);
				codeLength += 1;
				return codeLength;
			}
			
			if (myInteger != null) {
				sublength = myInteger.encode(reverseOS, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(reverseOS, sublength);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 2
				reverseOS.write(0xA2);
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

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
				BerLength explicitTagLength = new BerLength();
				tlvByteCount += explicitTagLength.decode(is);
				myInteger = new com.beanit.jasn1.compiler.various_tests.UntaggedInteger();
				tlvByteCount += myInteger.decode(is, true);
				tlvByteCount += explicitTagLength.readEocIfIndefinite(is);
				return tlvByteCount;
			}

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 3)) {
				BerLength explicitTagLength = new BerLength();
				tlvByteCount += explicitTagLength.decode(is);
				myBoolean = new BerBoolean();
				tlvByteCount += myBoolean.decode(is, true);
				tlvByteCount += explicitTagLength.readEocIfIndefinite(is);
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

			if (myInteger != null) {
				sb.append("myInteger: ").append(myInteger);
				return;
			}

			if (myBoolean != null) {
				sb.append("myBoolean: ").append(myBoolean);
				return;
			}

			sb.append("<none>");
		}

	}

	public static class MyChoice implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		public byte[] code = null;
		public static class MyChoice2 implements BerType, Serializable {

			private static final long serialVersionUID = 1L;

			public byte[] code = null;
			public com.beanit.jasn1.compiler.various_tests.UntaggedInteger myInteger = null;
			public BerBoolean myBoolean = null;
			
			public MyChoice2() {
			}

			public MyChoice2(byte[] code) {
				this.code = code;
			}

			public MyChoice2(com.beanit.jasn1.compiler.various_tests.UntaggedInteger myInteger, BerBoolean myBoolean) {
				this.myInteger = myInteger;
				this.myBoolean = myBoolean;
			}

			public int encode(OutputStream reverseOS) throws IOException {

				if (code != null) {
					for (int i = code.length - 1; i >= 0; i--) {
						reverseOS.write(code[i]);
					}
					return code.length;
				}

				int codeLength = 0;
				int sublength;

				if (myBoolean != null) {
					sublength = myBoolean.encode(reverseOS, true);
					codeLength += sublength;
					codeLength += BerLength.encodeLength(reverseOS, sublength);
					// write tag: CONTEXT_CLASS, CONSTRUCTED, 7
					reverseOS.write(0xA7);
					codeLength += 1;
					return codeLength;
				}
				
				if (myInteger != null) {
					sublength = myInteger.encode(reverseOS, true);
					codeLength += sublength;
					codeLength += BerLength.encodeLength(reverseOS, sublength);
					// write tag: CONTEXT_CLASS, CONSTRUCTED, 6
					reverseOS.write(0xA6);
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

				if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 6)) {
					BerLength explicitTagLength = new BerLength();
					tlvByteCount += explicitTagLength.decode(is);
					myInteger = new com.beanit.jasn1.compiler.various_tests.UntaggedInteger();
					tlvByteCount += myInteger.decode(is, true);
					tlvByteCount += explicitTagLength.readEocIfIndefinite(is);
					return tlvByteCount;
				}

				if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 7)) {
					BerLength explicitTagLength = new BerLength();
					tlvByteCount += explicitTagLength.decode(is);
					myBoolean = new BerBoolean();
					tlvByteCount += myBoolean.decode(is, true);
					tlvByteCount += explicitTagLength.readEocIfIndefinite(is);
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

				if (myInteger != null) {
					sb.append("myInteger: ").append(myInteger);
					return;
				}

				if (myBoolean != null) {
					sb.append("myBoolean: ").append(myBoolean);
					return;
				}

				sb.append("<none>");
			}

		}

		public static class MySequence implements BerType, Serializable {

			private static final long serialVersionUID = 1L;

			public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

			public byte[] code = null;
			public com.beanit.jasn1.compiler.various_tests.UntaggedInteger myInteger = null;
			public BerBoolean myBoolean = null;
			
			public MySequence() {
			}

			public MySequence(byte[] code) {
				this.code = code;
			}

			public MySequence(com.beanit.jasn1.compiler.various_tests.UntaggedInteger myInteger, BerBoolean myBoolean) {
				this.myInteger = myInteger;
				this.myBoolean = myBoolean;
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
				int sublength;

				sublength = myBoolean.encode(reverseOS, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(reverseOS, sublength);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 10
				reverseOS.write(0xAA);
				codeLength += 1;
				
				sublength = myInteger.encode(reverseOS, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(reverseOS, sublength);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 9
				reverseOS.write(0xA9);
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

				if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 9)) {
					vByteCount += length.decode(is);
					myInteger = new com.beanit.jasn1.compiler.various_tests.UntaggedInteger();
					vByteCount += myInteger.decode(is, true);
					vByteCount += length.readEocIfIndefinite(is);
					vByteCount += berTag.decode(is);
				}
				else {
					throw new IOException("Tag does not match mandatory sequence component.");
				}
				
				if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 10)) {
					vByteCount += length.decode(is);
					myBoolean = new BerBoolean();
					vByteCount += myBoolean.decode(is, true);
					vByteCount += length.readEocIfIndefinite(is);
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
				if (myInteger != null) {
					sb.append("myInteger: ").append(myInteger);
				}
				else {
					sb.append("myInteger: <empty-required-field>");
				}
				
				sb.append(",\n");
				for (int i = 0; i < indentLevel + 1; i++) {
					sb.append("\t");
				}
				if (myBoolean != null) {
					sb.append("myBoolean: ").append(myBoolean);
				}
				else {
					sb.append("myBoolean: <empty-required-field>");
				}
				
				sb.append("\n");
				for (int i = 0; i < indentLevel; i++) {
					sb.append("\t");
				}
				sb.append("}");
			}

		}

		public static class Myseqof implements BerType, Serializable {

			private static final long serialVersionUID = 1L;

			public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
			public byte[] code = null;
			public List<com.beanit.jasn1.compiler.various_tests.UntaggedInteger> seqOf = null;

			public Myseqof() {
				seqOf = new ArrayList<com.beanit.jasn1.compiler.various_tests.UntaggedInteger>();
			}

			public Myseqof(byte[] code) {
				this.code = code;
			}

			public Myseqof(List<com.beanit.jasn1.compiler.various_tests.UntaggedInteger> seqOf) {
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

					if (!berTag.equals(com.beanit.jasn1.compiler.various_tests.UntaggedInteger.tag)) {
						throw new IOException("Tag does not match mandatory sequence of/set of component.");
					}
					com.beanit.jasn1.compiler.various_tests.UntaggedInteger element = new com.beanit.jasn1.compiler.various_tests.UntaggedInteger();
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
					Iterator<com.beanit.jasn1.compiler.various_tests.UntaggedInteger> it = seqOf.iterator();
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

		public com.beanit.jasn1.compiler.various_tests.UntaggedInteger myInteger = null;
		public MyChoice2 myChoice2 = null;
		public MySequence mySequence = null;
		public Myseqof myseqof = null;
		
		public MyChoice() {
		}

		public MyChoice(byte[] code) {
			this.code = code;
		}

		public MyChoice(com.beanit.jasn1.compiler.various_tests.UntaggedInteger myInteger, MyChoice2 myChoice2, MySequence mySequence, Myseqof myseqof) {
			this.myInteger = myInteger;
			this.myChoice2 = myChoice2;
			this.mySequence = mySequence;
			this.myseqof = myseqof;
		}

		public int encode(OutputStream reverseOS) throws IOException {

			if (code != null) {
				for (int i = code.length - 1; i >= 0; i--) {
					reverseOS.write(code[i]);
				}
				return code.length;
			}

			int codeLength = 0;
			int sublength;

			if (myseqof != null) {
				sublength = myseqof.encode(reverseOS, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(reverseOS, sublength);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 1
				reverseOS.write(0xA1);
				codeLength += 1;
				return codeLength;
			}
			
			if (mySequence != null) {
				sublength = mySequence.encode(reverseOS, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(reverseOS, sublength);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 8
				reverseOS.write(0xA8);
				codeLength += 1;
				return codeLength;
			}
			
			if (myChoice2 != null) {
				sublength = myChoice2.encode(reverseOS);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(reverseOS, sublength);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 5
				reverseOS.write(0xA5);
				codeLength += 1;
				return codeLength;
			}
			
			if (myInteger != null) {
				sublength = myInteger.encode(reverseOS, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(reverseOS, sublength);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 4
				reverseOS.write(0xA4);
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

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 4)) {
				BerLength explicitTagLength = new BerLength();
				tlvByteCount += explicitTagLength.decode(is);
				myInteger = new com.beanit.jasn1.compiler.various_tests.UntaggedInteger();
				tlvByteCount += myInteger.decode(is, true);
				tlvByteCount += explicitTagLength.readEocIfIndefinite(is);
				return tlvByteCount;
			}

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 5)) {
				BerLength explicitTagLength = new BerLength();
				tlvByteCount += explicitTagLength.decode(is);
				myChoice2 = new MyChoice2();
				tlvByteCount += myChoice2.decode(is, null);
				tlvByteCount += explicitTagLength.readEocIfIndefinite(is);
				return tlvByteCount;
			}

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 8)) {
				BerLength explicitTagLength = new BerLength();
				tlvByteCount += explicitTagLength.decode(is);
				mySequence = new MySequence();
				tlvByteCount += mySequence.decode(is, true);
				tlvByteCount += explicitTagLength.readEocIfIndefinite(is);
				return tlvByteCount;
			}

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
				BerLength explicitTagLength = new BerLength();
				tlvByteCount += explicitTagLength.decode(is);
				myseqof = new Myseqof();
				tlvByteCount += myseqof.decode(is, true);
				tlvByteCount += explicitTagLength.readEocIfIndefinite(is);
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

			if (myInteger != null) {
				sb.append("myInteger: ").append(myInteger);
				return;
			}

			if (myChoice2 != null) {
				sb.append("myChoice2: ");
				myChoice2.appendAsString(sb, indentLevel + 1);
				return;
			}

			if (mySequence != null) {
				sb.append("mySequence: ");
				mySequence.appendAsString(sb, indentLevel + 1);
				return;
			}

			if (myseqof != null) {
				sb.append("myseqof: ");
				myseqof.appendAsString(sb, indentLevel + 1);
				return;
			}

			sb.append("<none>");
		}

	}

	public static class SequenceNameClashTest_ implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

		public byte[] code = null;
		public com.beanit.jasn1.compiler.various_tests.UntaggedInteger myInteger = null;
		public BerBoolean myBoolean = null;
		
		public SequenceNameClashTest_() {
		}

		public SequenceNameClashTest_(byte[] code) {
			this.code = code;
		}

		public SequenceNameClashTest_(com.beanit.jasn1.compiler.various_tests.UntaggedInteger myInteger, BerBoolean myBoolean) {
			this.myInteger = myInteger;
			this.myBoolean = myBoolean;
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
			int sublength;

			sublength = myBoolean.encode(reverseOS, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(reverseOS, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 10
			reverseOS.write(0xAA);
			codeLength += 1;
			
			sublength = myInteger.encode(reverseOS, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(reverseOS, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 9
			reverseOS.write(0xA9);
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

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 9)) {
				vByteCount += length.decode(is);
				myInteger = new com.beanit.jasn1.compiler.various_tests.UntaggedInteger();
				vByteCount += myInteger.decode(is, true);
				vByteCount += length.readEocIfIndefinite(is);
				vByteCount += berTag.decode(is);
			}
			else {
				throw new IOException("Tag does not match mandatory sequence component.");
			}
			
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 10)) {
				vByteCount += length.decode(is);
				myBoolean = new BerBoolean();
				vByteCount += myBoolean.decode(is, true);
				vByteCount += length.readEocIfIndefinite(is);
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
			if (myInteger != null) {
				sb.append("myInteger: ").append(myInteger);
			}
			else {
				sb.append("myInteger: <empty-required-field>");
			}
			
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			if (myBoolean != null) {
				sb.append("myBoolean: ").append(myBoolean);
			}
			else {
				sb.append("myBoolean: <empty-required-field>");
			}
			
			sb.append("\n");
			for (int i = 0; i < indentLevel; i++) {
				sb.append("\t");
			}
			sb.append("}");
		}

	}

	public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 43);

	public byte[] code = null;
	public Myseqof myseqof = null;
	public UntaggedInteger untaggedInteger = null;
	public MyChoice myChoice = null;
	public SequenceNameClashTest_ sequenceNameClashTest = null;
	
	public SequenceNameClashTest() {
	}

	public SequenceNameClashTest(byte[] code) {
		this.code = code;
	}

	public SequenceNameClashTest(Myseqof myseqof, UntaggedInteger untaggedInteger, MyChoice myChoice, SequenceNameClashTest_ sequenceNameClashTest) {
		this.myseqof = myseqof;
		this.untaggedInteger = untaggedInteger;
		this.myChoice = myChoice;
		this.sequenceNameClashTest = sequenceNameClashTest;
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
		int sublength;

		sublength = sequenceNameClashTest.encode(reverseOS, true);
		codeLength += sublength;
		codeLength += BerLength.encodeLength(reverseOS, sublength);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 8
		reverseOS.write(0xA8);
		codeLength += 1;
		
		codeLength += myChoice.encode(reverseOS);
		
		if (untaggedInteger != null) {
			codeLength += untaggedInteger.encode(reverseOS);
		}
		
		sublength = myseqof.encode(reverseOS, true);
		codeLength += sublength;
		codeLength += BerLength.encodeLength(reverseOS, sublength);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 1
		reverseOS.write(0xA1);
		codeLength += 1;
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);
		reverseOS.write(0x30);
		codeLength++;

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
		int numDecodedBytes;
		BerTag berTag = new BerTag();

		if (withTag) {
			tlByteCount += tag.decodeAndCheck(is);
		}

		BerLength explicitTagLength = new BerLength();
		tlByteCount += explicitTagLength.decode(is);
		tlByteCount += BerTag.SEQUENCE.decodeAndCheck(is);

		BerLength length = new BerLength();
		tlByteCount += length.decode(is);
		int lengthVal = length.val;
		vByteCount += berTag.decode(is);

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
			vByteCount += length.decode(is);
			myseqof = new Myseqof();
			vByteCount += myseqof.decode(is, true);
			vByteCount += length.readEocIfIndefinite(is);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		untaggedInteger = new UntaggedInteger();
		numDecodedBytes = untaggedInteger.decode(is, berTag);
		if (numDecodedBytes != 0) {
			vByteCount += numDecodedBytes;
			vByteCount += berTag.decode(is);
		}
		else {
			untaggedInteger = null;
		}
		myChoice = new MyChoice();
		numDecodedBytes = myChoice.decode(is, berTag);
		if (numDecodedBytes != 0) {
			vByteCount += numDecodedBytes;
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 8)) {
			vByteCount += length.decode(is);
			sequenceNameClashTest = new SequenceNameClashTest_();
			vByteCount += sequenceNameClashTest.decode(is, true);
			vByteCount += length.readEocIfIndefinite(is);
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
			vByteCount += explicitTagLength.readEocIfIndefinite(is);
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
		if (myseqof != null) {
			sb.append("myseqof: ");
			myseqof.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("myseqof: <empty-required-field>");
		}
		
		if (untaggedInteger != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("untaggedInteger: ");
			untaggedInteger.appendAsString(sb, indentLevel + 1);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (myChoice != null) {
			sb.append("myChoice: ");
			myChoice.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("myChoice: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (sequenceNameClashTest != null) {
			sb.append("sequenceNameClashTest: ");
			sequenceNameClashTest.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("sequenceNameClashTest: <empty-required-field>");
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

