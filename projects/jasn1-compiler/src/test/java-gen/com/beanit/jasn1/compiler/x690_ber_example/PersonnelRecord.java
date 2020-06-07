/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.x690_ber_example;

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


public class PersonnelRecord implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static class Children implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
		public byte[] code = null;
		private List<ChildInformation> seqOf = null;

		public Children() {
			seqOf = new ArrayList<ChildInformation>();
		}

		public Children(byte[] code) {
			this.code = code;
		}

		public List<ChildInformation> getChildInformation() {
			if (seqOf == null) {
				seqOf = new ArrayList<ChildInformation>();
			}
			return seqOf;
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

				if (!berTag.equals(ChildInformation.tag)) {
					throw new IOException("Tag does not match mandatory sequence of/set of component.");
				}
				ChildInformation element = new ChildInformation();
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
				Iterator<ChildInformation> it = seqOf.iterator();
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

	public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.CONSTRUCTED, 0);

	public byte[] code = null;
	private Name name = null;
	private BerVisibleString title = null;
	private EmployeeNumber number = null;
	private Date dateOfHire = null;
	private Name nameOfSpouse = null;
	private Children children = null;
	
	public PersonnelRecord() {
	}

	public PersonnelRecord(byte[] code) {
		this.code = code;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	public void setTitle(BerVisibleString title) {
		this.title = title;
	}

	public BerVisibleString getTitle() {
		return title;
	}

	public void setNumber(EmployeeNumber number) {
		this.number = number;
	}

	public EmployeeNumber getNumber() {
		return number;
	}

	public void setDateOfHire(Date dateOfHire) {
		this.dateOfHire = dateOfHire;
	}

	public Date getDateOfHire() {
		return dateOfHire;
	}

	public void setNameOfSpouse(Name nameOfSpouse) {
		this.nameOfSpouse = nameOfSpouse;
	}

	public Name getNameOfSpouse() {
		return nameOfSpouse;
	}

	public void setChildren(Children children) {
		this.children = children;
	}

	public Children getChildren() {
		return children;
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

		if (children != null) {
			codeLength += children.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 3
			reverseOS.write(0xA3);
			codeLength += 1;
		}
		
		sublength = nameOfSpouse.encode(reverseOS, true);
		codeLength += sublength;
		codeLength += BerLength.encodeLength(reverseOS, sublength);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 2
		reverseOS.write(0xA2);
		codeLength += 1;
		
		sublength = dateOfHire.encode(reverseOS, true);
		codeLength += sublength;
		codeLength += BerLength.encodeLength(reverseOS, sublength);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 1
		reverseOS.write(0xA1);
		codeLength += 1;
		
		codeLength += number.encode(reverseOS, true);
		
		sublength = title.encode(reverseOS, true);
		codeLength += sublength;
		codeLength += BerLength.encodeLength(reverseOS, sublength);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
		reverseOS.write(0xA0);
		codeLength += 1;
		
		codeLength += name.encode(reverseOS, true);
		
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
			if (berTag.equals(Name.tag)) {
				name = new Name();
				vByteCount += name.decode(is, false);
			}
			else if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
				vByteCount += length.decode(is);
				title = new BerVisibleString();
				vByteCount += title.decode(is, true);
				vByteCount += length.readEocIfIndefinite(is);
			}
			else if (berTag.equals(EmployeeNumber.tag)) {
				number = new EmployeeNumber();
				vByteCount += number.decode(is, false);
			}
			else if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
				vByteCount += length.decode(is);
				dateOfHire = new Date();
				vByteCount += dateOfHire.decode(is, true);
				vByteCount += length.readEocIfIndefinite(is);
			}
			else if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
				vByteCount += length.decode(is);
				nameOfSpouse = new Name();
				vByteCount += nameOfSpouse.decode(is, true);
				vByteCount += length.readEocIfIndefinite(is);
			}
			else if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 3)) {
				children = new Children();
				vByteCount += children.decode(is, false);
			}
			else if (lengthVal < 0 && berTag.equals(0, 0, 0)) {
				vByteCount += BerLength.readEocByte(is);
				return tlByteCount + vByteCount;
			}
			else {
				throw new IOException("Tag does not match any set component: " + berTag);
			}
		}
		if (vByteCount != lengthVal) {
			throw new IOException("Length of set does not match length tag, length tag: " + lengthVal + ", actual set length: " + vByteCount);
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

		sb.append("{");
		sb.append("\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (name != null) {
			sb.append("name: ");
			name.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("name: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (title != null) {
			sb.append("title: ").append(title);
		}
		else {
			sb.append("title: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (number != null) {
			sb.append("number: ").append(number);
		}
		else {
			sb.append("number: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (dateOfHire != null) {
			sb.append("dateOfHire: ").append(dateOfHire);
		}
		else {
			sb.append("dateOfHire: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (nameOfSpouse != null) {
			sb.append("nameOfSpouse: ");
			nameOfSpouse.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("nameOfSpouse: <empty-required-field>");
		}
		
		if (children != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("children: ");
			children.appendAsString(sb, indentLevel + 1);
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

