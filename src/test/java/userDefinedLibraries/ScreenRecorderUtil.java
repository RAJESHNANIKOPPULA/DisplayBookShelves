package userDefinedLibraries;

/***************************************
 *                                     *
 * AUTHOR       : Rajesh Koppula       *
 * DATE CREATED : 06-JUNE-2023         *
 * PROJECT      : DisplayBookshelves   *
 *                                     *
 ***************************************/

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

/***********************************************************************************
*                                                                                  *
* Class Name     : ScreenRecorderUtil                                              * 
* Description    : To Record the screen of the execution of all the test cases     *
* Parent Class   : ScreenRecorder                                                  *
*                                                                                  *
************************************************************************************/

public class ScreenRecorderUtil extends ScreenRecorder {

	public static ScreenRecorder screenRecorder;
	public static int flag = 0;
	public String name;

	/*
	 * 
	 * Method Name  : ScreenRecorderUtil 
	 * Method Usage : Constructor of the class ScreenRecorderUtil.
	 * 
	 */

	public ScreenRecorderUtil(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat, Format screenFormat,
			Format mouseFormat, Format audioFormat, File movieFolder, String name) throws IOException, AWTException {

		super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
		this.name = name;

	}

	/*
	 * 
	 * Method Name  : createMovieFile
	 * Method Usage : To Create folder if its not present and To Name and Save the file.
	 * Return       : File
	 * 
	 */

	@Override
	protected File createMovieFile(Format fileFormat) throws IOException {

		if (!movieFolder.exists())
			movieFolder.mkdirs();
		else if (!movieFolder.isDirectory())
			throw new IOException("\"" + movieFolder + "\" is not a directory.");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");

		if (flag == 0) {
			flag++;
			return new File(movieFolder, "Chrome Driver - " + name + "-" + dateFormat.format(new Date()) + "."
					+ Registry.getInstance().getExtension(fileFormat));
		} else
			return new File(movieFolder, "MSEdge Driver - " + name + "-" + dateFormat.format(new Date()) + "."
					+ Registry.getInstance().getExtension(fileFormat));

	}

	/*
	 * 
	 * Method Name  : startRecord
	 * Method Usage : To Start the record of the test cases excution.
	 * Return       : void
	 * 
	 */

	public static void startRecord(String methodName) throws Exception {

		File file = new File("./ScreenRecording/");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;

		Rectangle captureSize = new Rectangle(0, 0, width, height);

		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		screenRecorder = new ScreenRecorderUtil(gc, captureSize,
				new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
						CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
						Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
				null, file, methodName);
		screenRecorder.start();

	}

	/*
	 * 
	 * Method Name  : stopRecord
	 * Method Usage : To Start the record of the test cases excution.
	 * Return       : void
	 * 
	 */

	public static void stopRecord() throws Exception {

		screenRecorder.stop();

	}
	
}