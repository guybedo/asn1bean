/**
 * This class file was automatically generated by jASN1 v1.10.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.rspdefinitions;

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
import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;
import org.openmuc.jasn1.ber.types.string.*;

import org.openmuc.jasn1.compiler.pkix1explicit88.Certificate;
import org.openmuc.jasn1.compiler.pkix1explicit88.CertificateList;
import org.openmuc.jasn1.compiler.pkix1explicit88.Time;
import org.openmuc.jasn1.compiler.pkix1implicit88.SubjectKeyIdentifier;

public class RemoteProfileProvisioningRequest implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public byte[] code = null;
	public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2);

	public InitiateAuthenticationRequest initiateAuthenticationRequest = null;
	public AuthenticateClientRequest authenticateClientRequest = null;
	public GetBoundProfilePackageRequest getBoundProfilePackageRequest = null;
	public CancelSessionRequestEs9 cancelSessionRequestEs9 = null;
	public HandleNotification handleNotification = null;
	
	public RemoteProfileProvisioningRequest() {
	}

	public RemoteProfileProvisioningRequest(byte[] code) {
		this.code = code;
	}

	public RemoteProfileProvisioningRequest(InitiateAuthenticationRequest initiateAuthenticationRequest, AuthenticateClientRequest authenticateClientRequest, GetBoundProfilePackageRequest getBoundProfilePackageRequest, CancelSessionRequestEs9 cancelSessionRequestEs9, HandleNotification handleNotification) {
		this.initiateAuthenticationRequest = initiateAuthenticationRequest;
		this.authenticateClientRequest = authenticateClientRequest;
		this.getBoundProfilePackageRequest = getBoundProfilePackageRequest;
		this.cancelSessionRequestEs9 = cancelSessionRequestEs9;
		this.handleNotification = handleNotification;
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
		if (handleNotification != null) {
			codeLength += handleNotification.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 61
			reverseOS.write(0x3D);
			reverseOS.write(0xBF);
			codeLength += 2;
			codeLength += BerLength.encodeLength(reverseOS, codeLength);
			if (withTag) {
				codeLength += tag.encode(reverseOS);
			}
			return codeLength;
		}
		
		if (cancelSessionRequestEs9 != null) {
			codeLength += cancelSessionRequestEs9.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 65
			reverseOS.write(0x41);
			reverseOS.write(0xBF);
			codeLength += 2;
			codeLength += BerLength.encodeLength(reverseOS, codeLength);
			if (withTag) {
				codeLength += tag.encode(reverseOS);
			}
			return codeLength;
		}
		
		if (getBoundProfilePackageRequest != null) {
			codeLength += getBoundProfilePackageRequest.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 58
			reverseOS.write(0x3A);
			reverseOS.write(0xBF);
			codeLength += 2;
			codeLength += BerLength.encodeLength(reverseOS, codeLength);
			if (withTag) {
				codeLength += tag.encode(reverseOS);
			}
			return codeLength;
		}
		
		if (authenticateClientRequest != null) {
			codeLength += authenticateClientRequest.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 59
			reverseOS.write(0x3B);
			reverseOS.write(0xBF);
			codeLength += 2;
			codeLength += BerLength.encodeLength(reverseOS, codeLength);
			if (withTag) {
				codeLength += tag.encode(reverseOS);
			}
			return codeLength;
		}
		
		if (initiateAuthenticationRequest != null) {
			codeLength += initiateAuthenticationRequest.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 57
			reverseOS.write(0x39);
			reverseOS.write(0xBF);
			codeLength += 2;
			codeLength += BerLength.encodeLength(reverseOS, codeLength);
			if (withTag) {
				codeLength += tag.encode(reverseOS);
			}
			return codeLength;
		}
		
		throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int codeLength = 0;
		BerLength length = new BerLength();
		BerTag berTag = new BerTag();

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		codeLength += length.decode(is);
		codeLength += berTag.decode(is);

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 57)) {
			initiateAuthenticationRequest = new InitiateAuthenticationRequest();
			codeLength += initiateAuthenticationRequest.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 59)) {
			authenticateClientRequest = new AuthenticateClientRequest();
			codeLength += authenticateClientRequest.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 58)) {
			getBoundProfilePackageRequest = new GetBoundProfilePackageRequest();
			codeLength += getBoundProfilePackageRequest.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 65)) {
			cancelSessionRequestEs9 = new CancelSessionRequestEs9();
			codeLength += cancelSessionRequestEs9.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 61)) {
			handleNotification = new HandleNotification();
			codeLength += handleNotification.decode(is, false);
			return codeLength;
		}

		throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
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

		if (initiateAuthenticationRequest != null) {
			sb.append("initiateAuthenticationRequest: ");
			initiateAuthenticationRequest.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (authenticateClientRequest != null) {
			sb.append("authenticateClientRequest: ");
			authenticateClientRequest.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (getBoundProfilePackageRequest != null) {
			sb.append("getBoundProfilePackageRequest: ");
			getBoundProfilePackageRequest.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (cancelSessionRequestEs9 != null) {
			sb.append("cancelSessionRequestEs9: ");
			cancelSessionRequestEs9.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (handleNotification != null) {
			sb.append("handleNotification: ");
			handleNotification.appendAsString(sb, indentLevel + 1);
			return;
		}

		sb.append("<none>");
	}

}

