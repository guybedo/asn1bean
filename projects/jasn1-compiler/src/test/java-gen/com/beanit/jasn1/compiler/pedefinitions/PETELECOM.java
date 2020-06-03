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


public class PETELECOM implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	public PEHeader telecomHeader = null;
	public BerObjectIdentifier templateID = null;
	public File dfTelecom = null;
	public File efArr = null;
	public File efRma = null;
	public File efSume = null;
	public File efIceDn = null;
	public File efIceFf = null;
	public File efPsismsc = null;
	public File dfGraphics = null;
	public File efImg = null;
	public File efIidf = null;
	public File efIceGraphics = null;
	public File efLaunchScws = null;
	public File efIcon = null;
	public File dfPhonebook = null;
	public File efPbr = null;
	public File efExt1 = null;
	public File efAas = null;
	public File efGas = null;
	public File efPsc = null;
	public File efCc = null;
	public File efPuid = null;
	public File efIap = null;
	public File efAdn = null;
	public File efPbc = null;
	public File efAnr = null;
	public File efPuri = null;
	public File efEmail = null;
	public File efSne = null;
	public File efUid = null;
	public File efGrp = null;
	public File efCcp1 = null;
	public File dfMultimedia = null;
	public File efMml = null;
	public File efMmdf = null;
	public File dfMmss = null;
	public File efMlpl = null;
	public File efMspl = null;
	public File efMmssmode = null;
	
	public PETELECOM() {
	}

	public PETELECOM(byte[] code) {
		this.code = code;
	}

	public PETELECOM(PEHeader telecomHeader, BerObjectIdentifier templateID, File dfTelecom, File efArr, File efRma, File efSume, File efIceDn, File efIceFf, File efPsismsc, File dfGraphics, File efImg, File efIidf, File efIceGraphics, File efLaunchScws, File efIcon, File dfPhonebook, File efPbr, File efExt1, File efAas, File efGas, File efPsc, File efCc, File efPuid, File efIap, File efAdn, File efPbc, File efAnr, File efPuri, File efEmail, File efSne, File efUid, File efGrp, File efCcp1, File dfMultimedia, File efMml, File efMmdf, File dfMmss, File efMlpl, File efMspl, File efMmssmode) {
		this.telecomHeader = telecomHeader;
		this.templateID = templateID;
		this.dfTelecom = dfTelecom;
		this.efArr = efArr;
		this.efRma = efRma;
		this.efSume = efSume;
		this.efIceDn = efIceDn;
		this.efIceFf = efIceFf;
		this.efPsismsc = efPsismsc;
		this.dfGraphics = dfGraphics;
		this.efImg = efImg;
		this.efIidf = efIidf;
		this.efIceGraphics = efIceGraphics;
		this.efLaunchScws = efLaunchScws;
		this.efIcon = efIcon;
		this.dfPhonebook = dfPhonebook;
		this.efPbr = efPbr;
		this.efExt1 = efExt1;
		this.efAas = efAas;
		this.efGas = efGas;
		this.efPsc = efPsc;
		this.efCc = efCc;
		this.efPuid = efPuid;
		this.efIap = efIap;
		this.efAdn = efAdn;
		this.efPbc = efPbc;
		this.efAnr = efAnr;
		this.efPuri = efPuri;
		this.efEmail = efEmail;
		this.efSne = efSne;
		this.efUid = efUid;
		this.efGrp = efGrp;
		this.efCcp1 = efCcp1;
		this.dfMultimedia = dfMultimedia;
		this.efMml = efMml;
		this.efMmdf = efMmdf;
		this.dfMmss = dfMmss;
		this.efMlpl = efMlpl;
		this.efMspl = efMspl;
		this.efMmssmode = efMmssmode;
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
		if (efMmssmode != null) {
			codeLength += efMmssmode.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 39
			reverseOS.write(0x27);
			reverseOS.write(0xBF);
			codeLength += 2;
		}
		
		if (efMspl != null) {
			codeLength += efMspl.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 38
			reverseOS.write(0x26);
			reverseOS.write(0xBF);
			codeLength += 2;
		}
		
		if (efMlpl != null) {
			codeLength += efMlpl.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 37
			reverseOS.write(0x25);
			reverseOS.write(0xBF);
			codeLength += 2;
		}
		
		if (dfMmss != null) {
			codeLength += dfMmss.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 36
			reverseOS.write(0x24);
			reverseOS.write(0xBF);
			codeLength += 2;
		}
		
		if (efMmdf != null) {
			codeLength += efMmdf.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 35
			reverseOS.write(0x23);
			reverseOS.write(0xBF);
			codeLength += 2;
		}
		
		if (efMml != null) {
			codeLength += efMml.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 34
			reverseOS.write(0x22);
			reverseOS.write(0xBF);
			codeLength += 2;
		}
		
		if (dfMultimedia != null) {
			codeLength += dfMultimedia.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 33
			reverseOS.write(0x21);
			reverseOS.write(0xBF);
			codeLength += 2;
		}
		
		if (efCcp1 != null) {
			codeLength += efCcp1.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 32
			reverseOS.write(0x20);
			reverseOS.write(0xBF);
			codeLength += 2;
		}
		
		if (efGrp != null) {
			codeLength += efGrp.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 31
			reverseOS.write(0x1F);
			reverseOS.write(0xBF);
			codeLength += 2;
		}
		
		if (efUid != null) {
			codeLength += efUid.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 30
			reverseOS.write(0xBE);
			codeLength += 1;
		}
		
		if (efSne != null) {
			codeLength += efSne.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 29
			reverseOS.write(0xBD);
			codeLength += 1;
		}
		
		if (efEmail != null) {
			codeLength += efEmail.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 28
			reverseOS.write(0xBC);
			codeLength += 1;
		}
		
		if (efPuri != null) {
			codeLength += efPuri.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 27
			reverseOS.write(0xBB);
			codeLength += 1;
		}
		
		if (efAnr != null) {
			codeLength += efAnr.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 26
			reverseOS.write(0xBA);
			codeLength += 1;
		}
		
		if (efPbc != null) {
			codeLength += efPbc.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 25
			reverseOS.write(0xB9);
			codeLength += 1;
		}
		
		if (efAdn != null) {
			codeLength += efAdn.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 24
			reverseOS.write(0xB8);
			codeLength += 1;
		}
		
		if (efIap != null) {
			codeLength += efIap.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 23
			reverseOS.write(0xB7);
			codeLength += 1;
		}
		
		if (efPuid != null) {
			codeLength += efPuid.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 22
			reverseOS.write(0xB6);
			codeLength += 1;
		}
		
		if (efCc != null) {
			codeLength += efCc.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 21
			reverseOS.write(0xB5);
			codeLength += 1;
		}
		
		if (efPsc != null) {
			codeLength += efPsc.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 20
			reverseOS.write(0xB4);
			codeLength += 1;
		}
		
		if (efGas != null) {
			codeLength += efGas.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 19
			reverseOS.write(0xB3);
			codeLength += 1;
		}
		
		if (efAas != null) {
			codeLength += efAas.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 18
			reverseOS.write(0xB2);
			codeLength += 1;
		}
		
		if (efExt1 != null) {
			codeLength += efExt1.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 17
			reverseOS.write(0xB1);
			codeLength += 1;
		}
		
		if (efPbr != null) {
			codeLength += efPbr.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 16
			reverseOS.write(0xB0);
			codeLength += 1;
		}
		
		if (dfPhonebook != null) {
			codeLength += dfPhonebook.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 15
			reverseOS.write(0xAF);
			codeLength += 1;
		}
		
		if (efIcon != null) {
			codeLength += efIcon.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 14
			reverseOS.write(0xAE);
			codeLength += 1;
		}
		
		if (efLaunchScws != null) {
			codeLength += efLaunchScws.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 13
			reverseOS.write(0xAD);
			codeLength += 1;
		}
		
		if (efIceGraphics != null) {
			codeLength += efIceGraphics.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 12
			reverseOS.write(0xAC);
			codeLength += 1;
		}
		
		if (efIidf != null) {
			codeLength += efIidf.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 11
			reverseOS.write(0xAB);
			codeLength += 1;
		}
		
		if (efImg != null) {
			codeLength += efImg.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 10
			reverseOS.write(0xAA);
			codeLength += 1;
		}
		
		if (dfGraphics != null) {
			codeLength += dfGraphics.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 9
			reverseOS.write(0xA9);
			codeLength += 1;
		}
		
		if (efPsismsc != null) {
			codeLength += efPsismsc.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 8
			reverseOS.write(0xA8);
			codeLength += 1;
		}
		
		if (efIceFf != null) {
			codeLength += efIceFf.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 7
			reverseOS.write(0xA7);
			codeLength += 1;
		}
		
		if (efIceDn != null) {
			codeLength += efIceDn.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 6
			reverseOS.write(0xA6);
			codeLength += 1;
		}
		
		if (efSume != null) {
			codeLength += efSume.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 5
			reverseOS.write(0xA5);
			codeLength += 1;
		}
		
		if (efRma != null) {
			codeLength += efRma.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 4
			reverseOS.write(0xA4);
			codeLength += 1;
		}
		
		if (efArr != null) {
			codeLength += efArr.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 3
			reverseOS.write(0xA3);
			codeLength += 1;
		}
		
		codeLength += dfTelecom.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 2
		reverseOS.write(0xA2);
		codeLength += 1;
		
		codeLength += templateID.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 1
		reverseOS.write(0x81);
		codeLength += 1;
		
		codeLength += telecomHeader.encode(reverseOS, false);
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
			telecomHeader = new PEHeader();
			vByteCount += telecomHeader.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
			templateID = new BerObjectIdentifier();
			vByteCount += templateID.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
			dfTelecom = new File();
			vByteCount += dfTelecom.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 3)) {
			efArr = new File();
			vByteCount += efArr.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 4)) {
			efRma = new File();
			vByteCount += efRma.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 5)) {
			efSume = new File();
			vByteCount += efSume.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 6)) {
			efIceDn = new File();
			vByteCount += efIceDn.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 7)) {
			efIceFf = new File();
			vByteCount += efIceFf.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 8)) {
			efPsismsc = new File();
			vByteCount += efPsismsc.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 9)) {
			dfGraphics = new File();
			vByteCount += dfGraphics.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 10)) {
			efImg = new File();
			vByteCount += efImg.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 11)) {
			efIidf = new File();
			vByteCount += efIidf.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 12)) {
			efIceGraphics = new File();
			vByteCount += efIceGraphics.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 13)) {
			efLaunchScws = new File();
			vByteCount += efLaunchScws.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 14)) {
			efIcon = new File();
			vByteCount += efIcon.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 15)) {
			dfPhonebook = new File();
			vByteCount += dfPhonebook.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 16)) {
			efPbr = new File();
			vByteCount += efPbr.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 17)) {
			efExt1 = new File();
			vByteCount += efExt1.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 18)) {
			efAas = new File();
			vByteCount += efAas.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 19)) {
			efGas = new File();
			vByteCount += efGas.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 20)) {
			efPsc = new File();
			vByteCount += efPsc.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 21)) {
			efCc = new File();
			vByteCount += efCc.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 22)) {
			efPuid = new File();
			vByteCount += efPuid.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 23)) {
			efIap = new File();
			vByteCount += efIap.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 24)) {
			efAdn = new File();
			vByteCount += efAdn.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 25)) {
			efPbc = new File();
			vByteCount += efPbc.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 26)) {
			efAnr = new File();
			vByteCount += efAnr.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 27)) {
			efPuri = new File();
			vByteCount += efPuri.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 28)) {
			efEmail = new File();
			vByteCount += efEmail.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 29)) {
			efSne = new File();
			vByteCount += efSne.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 30)) {
			efUid = new File();
			vByteCount += efUid.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 31)) {
			efGrp = new File();
			vByteCount += efGrp.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 32)) {
			efCcp1 = new File();
			vByteCount += efCcp1.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 33)) {
			dfMultimedia = new File();
			vByteCount += dfMultimedia.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 34)) {
			efMml = new File();
			vByteCount += efMml.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 35)) {
			efMmdf = new File();
			vByteCount += efMmdf.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 36)) {
			dfMmss = new File();
			vByteCount += dfMmss.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 37)) {
			efMlpl = new File();
			vByteCount += efMlpl.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 38)) {
			efMspl = new File();
			vByteCount += efMspl.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 39)) {
			efMmssmode = new File();
			vByteCount += efMmssmode.decode(is, false);
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
		if (telecomHeader != null) {
			sb.append("telecomHeader: ");
			telecomHeader.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("telecomHeader: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (templateID != null) {
			sb.append("templateID: ").append(templateID);
		}
		else {
			sb.append("templateID: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (dfTelecom != null) {
			sb.append("dfTelecom: ");
			dfTelecom.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("dfTelecom: <empty-required-field>");
		}
		
		if (efArr != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efArr: ");
			efArr.appendAsString(sb, indentLevel + 1);
		}
		
		if (efRma != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efRma: ");
			efRma.appendAsString(sb, indentLevel + 1);
		}
		
		if (efSume != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efSume: ");
			efSume.appendAsString(sb, indentLevel + 1);
		}
		
		if (efIceDn != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efIceDn: ");
			efIceDn.appendAsString(sb, indentLevel + 1);
		}
		
		if (efIceFf != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efIceFf: ");
			efIceFf.appendAsString(sb, indentLevel + 1);
		}
		
		if (efPsismsc != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efPsismsc: ");
			efPsismsc.appendAsString(sb, indentLevel + 1);
		}
		
		if (dfGraphics != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("dfGraphics: ");
			dfGraphics.appendAsString(sb, indentLevel + 1);
		}
		
		if (efImg != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efImg: ");
			efImg.appendAsString(sb, indentLevel + 1);
		}
		
		if (efIidf != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efIidf: ");
			efIidf.appendAsString(sb, indentLevel + 1);
		}
		
		if (efIceGraphics != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efIceGraphics: ");
			efIceGraphics.appendAsString(sb, indentLevel + 1);
		}
		
		if (efLaunchScws != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efLaunchScws: ");
			efLaunchScws.appendAsString(sb, indentLevel + 1);
		}
		
		if (efIcon != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efIcon: ");
			efIcon.appendAsString(sb, indentLevel + 1);
		}
		
		if (dfPhonebook != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("dfPhonebook: ");
			dfPhonebook.appendAsString(sb, indentLevel + 1);
		}
		
		if (efPbr != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efPbr: ");
			efPbr.appendAsString(sb, indentLevel + 1);
		}
		
		if (efExt1 != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efExt1: ");
			efExt1.appendAsString(sb, indentLevel + 1);
		}
		
		if (efAas != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efAas: ");
			efAas.appendAsString(sb, indentLevel + 1);
		}
		
		if (efGas != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efGas: ");
			efGas.appendAsString(sb, indentLevel + 1);
		}
		
		if (efPsc != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efPsc: ");
			efPsc.appendAsString(sb, indentLevel + 1);
		}
		
		if (efCc != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efCc: ");
			efCc.appendAsString(sb, indentLevel + 1);
		}
		
		if (efPuid != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efPuid: ");
			efPuid.appendAsString(sb, indentLevel + 1);
		}
		
		if (efIap != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efIap: ");
			efIap.appendAsString(sb, indentLevel + 1);
		}
		
		if (efAdn != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efAdn: ");
			efAdn.appendAsString(sb, indentLevel + 1);
		}
		
		if (efPbc != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efPbc: ");
			efPbc.appendAsString(sb, indentLevel + 1);
		}
		
		if (efAnr != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efAnr: ");
			efAnr.appendAsString(sb, indentLevel + 1);
		}
		
		if (efPuri != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efPuri: ");
			efPuri.appendAsString(sb, indentLevel + 1);
		}
		
		if (efEmail != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efEmail: ");
			efEmail.appendAsString(sb, indentLevel + 1);
		}
		
		if (efSne != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efSne: ");
			efSne.appendAsString(sb, indentLevel + 1);
		}
		
		if (efUid != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efUid: ");
			efUid.appendAsString(sb, indentLevel + 1);
		}
		
		if (efGrp != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efGrp: ");
			efGrp.appendAsString(sb, indentLevel + 1);
		}
		
		if (efCcp1 != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efCcp1: ");
			efCcp1.appendAsString(sb, indentLevel + 1);
		}
		
		if (dfMultimedia != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("dfMultimedia: ");
			dfMultimedia.appendAsString(sb, indentLevel + 1);
		}
		
		if (efMml != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efMml: ");
			efMml.appendAsString(sb, indentLevel + 1);
		}
		
		if (efMmdf != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efMmdf: ");
			efMmdf.appendAsString(sb, indentLevel + 1);
		}
		
		if (dfMmss != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("dfMmss: ");
			dfMmss.appendAsString(sb, indentLevel + 1);
		}
		
		if (efMlpl != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efMlpl: ");
			efMlpl.appendAsString(sb, indentLevel + 1);
		}
		
		if (efMspl != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efMspl: ");
			efMspl.appendAsString(sb, indentLevel + 1);
		}
		
		if (efMmssmode != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efMmssmode: ");
			efMmssmode.appendAsString(sb, indentLevel + 1);
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

