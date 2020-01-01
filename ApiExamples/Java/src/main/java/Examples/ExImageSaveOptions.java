package Examples;

//////////////////////////////////////////////////////////////////////////
// Copyright (c) 2001-2020 Aspose Pty Ltd. All Rights Reserved.
//
// This file is part of Aspose.Words. The source code in this file
// is only intended as a supplement to the documentation, and is provided
// "as is", without warranty of any kind, either expressed or implied.
//////////////////////////////////////////////////////////////////////////

import com.aspose.words.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class ExImageSaveOptions extends ApiExampleBase {
    @Test
    public void useGdiEmfRenderer() throws Exception {
        //ExStart
        //ExFor:ImageSaveOptions.UseGdiEmfRenderer
        //ExSummary:Shows how to save metafiles directly without using GDI+ to EMF.
        Document doc = new Document(getMyDir() + "SaveOptions.MyriadPro.docx");

        ImageSaveOptions saveOptions = new ImageSaveOptions(SaveFormat.EMF);
        saveOptions.setUseGdiEmfRenderer(false);

        doc.save(getArtifactsDir() + "SaveOptions.UseGdiEmfRenderer.docx", saveOptions);
        //ExEnd
    }

    @Test
    public void saveIntoGif() throws Exception {
        //ExStart
        //ExFor:ImageSaveOptions.PageIndex
        //ExSummary:Shows how to save specific document page as image file.
        Document doc = new Document(getMyDir() + "SaveOptions.MyriadPro.docx");

        ImageSaveOptions saveOptions = new ImageSaveOptions(SaveFormat.GIF);
        //Define which page will save
        saveOptions.setPageIndex(0);

        doc.save(getArtifactsDir() + "SaveOptions.PageIndex.gif", saveOptions);
        //ExEnd
    }

    @Test
    public void graphicsQuality() throws Exception {
        //ExStart
        //ExFor:GraphicsQualityOptions
        //ExFor:GraphicsQualityOptions.CompositingMode
        //ExFor:GraphicsQualityOptions.CompositingQuality
        //ExFor:GraphicsQualityOptions.InterpolationMode
        //ExFor:GraphicsQualityOptions.StringFormat
        //ExFor:GraphicsQualityOptions.SmoothingMode
        //ExFor:GraphicsQualityOptions.TextRenderingHint
        //ExFor:ImageSaveOptions.GraphicsQualityOptions
        //ExSummary:Shows how to set render quality options when converting documents to image formats.
        Document doc = new Document(getMyDir() + "SaveOptions.MyriadPro.docx");

        GraphicsQualityOptions qualityOptions = new GraphicsQualityOptions();
        qualityOptions.getRenderingHints().put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // SmoothingMode
        qualityOptions.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); // TextRenderingHint
        qualityOptions.getRenderingHints().put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY); // CompositingMode
        qualityOptions.getRenderingHints().put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY); // CompositingQuality
        qualityOptions.getRenderingHints().put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR); // InterpolationMode
        qualityOptions.getRenderingHints().put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON); // StringFormat

        ImageSaveOptions saveOptions = new ImageSaveOptions(SaveFormat.JPEG);
        saveOptions.setGraphicsQualityOptions(qualityOptions);

        doc.save(getArtifactsDir() + "SaveOptions.GraphicsQuality.jpeg", saveOptions);
        //ExEnd
    }

    @Test(groups = "SkipMono")
    public void converImageColorsToBlackAndWhite() throws Exception {
        //ExStart
        //ExFor:ImageColorMode
        //ExFor:ImagePixelFormat
        //ExFor:ImageSaveOptions.Clone
        //ExFor:ImageSaveOptions.ImageColorMode
        //ExFor:ImageSaveOptions.PixelFormat
        //ExSummary:Show how to convert document images to black and white with 1 bit per pixel
        Document doc = new Document(getMyDir() + "ImageSaveOptions.BlackAndWhite.docx");

        ImageSaveOptions imageSaveOptions = new ImageSaveOptions(SaveFormat.PNG);
        imageSaveOptions.setImageColorMode(ImageColorMode.BLACK_AND_WHITE);
        imageSaveOptions.setPixelFormat(ImagePixelFormat.FORMAT_1_BPP_INDEXED);

        // ImageSaveOptions instances can be cloned
        Assert.assertNotEquals(imageSaveOptions.deepClone(), imageSaveOptions);

        doc.save(getArtifactsDir() + "ImageSaveOptions.BlackAndWhite.png", imageSaveOptions);
        //ExEnd
    }

    @Test
    public void thresholdForFloydSteinbergDithering() throws Exception {
        //ExStart
        //ExFor:ImageBinarizationMethod
        //ExFor:ImageSaveOptions.ThresholdForFloydSteinbergDithering
        //ExFor:ImageSaveOptions.TiffBinarizationMethod
        //ExSummary: Shows how to control the threshold for TIFF binarization in the Floyd-Steinberg method
        Document doc = new Document(getMyDir() + "ImagesSaveOptions.ThresholdForFloydSteinbergDithering.docx");

        ImageSaveOptions options = new ImageSaveOptions(SaveFormat.TIFF);
        options.setTiffCompression(TiffCompression.CCITT_3);
        options.setImageColorMode(ImageColorMode.GRAYSCALE);
        options.setTiffBinarizationMethod(ImageBinarizationMethod.FLOYD_STEINBERG_DITHERING);
        // The default value of this property is 128. The higher value, the darker image.
        options.setThresholdForFloydSteinbergDithering((byte) 254);

        doc.save(getArtifactsDir() + "ImagesSaveOptions.ThresholdForFloydSteinbergDithering.tiff", options);
        //ExEnd
    }

    @Test
    public void editImage() throws Exception {
        //ExStart
        //ExFor:ImageSaveOptions.HorizontalResolution
        //ExFor:ImageSaveOptions.ImageBrightness
        //ExFor:ImageSaveOptions.ImageContrast
        //ExFor:ImageSaveOptions.SaveFormat
        //ExFor:ImageSaveOptions.Scale
        //ExFor:ImageSaveOptions.VerticalResolution
        //ExSummary:
        Document doc = new Document(getMyDir() + "Rendering.doc");

        // When saving the document as an image, we can use an ImageSaveOptions object to edit various aspects of it
        ImageSaveOptions options = new ImageSaveOptions(SaveFormat.PNG);
        {
            options.setImageBrightness(0.3f);     // 0 - 1 scale, default at 0.5
            options.setImageContrast(0.7f);       // 0 - 1 scale, default at 0.5
            options.setHorizontalResolution(72f); // Default at 96.0 meaning 96dpi, image dimensions will be affected if we change resolution
            options.setVerticalResolution(72f);   // Default at 96.0 meaning 96dpi
            options.setScale(96f / 72f);           // Default at 1.0 for normal scale, can be used to negate resolution impact in image size
        }

        doc.save(getArtifactsDir() + "ImagesSaveOptions.EditImage.png", options);
        //ExEnd
    }

    @Test
    public void windowsMetaFile() throws Exception {
        //ExStart
        //ExFor:ImageSaveOptions.MetafileRenderingOptions
        //ExSummary:Shows how to set the rendering mode for Windows Metafiles.
        Document doc = new Document();
        DocumentBuilder builder = new DocumentBuilder(doc);

        // Use a DocumentBuilder to insert a .wmf image into the document
        builder.insertImage(getImageDir() + "Hammer.wmf");

        // For documents that contain .wmf images, when converting the documents themselves to images,
        // we can use a ImageSaveOptions object to designate a rendering method for the .wmf images
        ImageSaveOptions options = new ImageSaveOptions(SaveFormat.PNG);
        options.getMetafileRenderingOptions().setRenderingMode(MetafileRenderingMode.BITMAP);

        doc.save(getArtifactsDir() + "ImagesSaveOptions.WindowsMetaFile.png", options);
        //ExEnd
    }
}
