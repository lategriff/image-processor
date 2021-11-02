import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import model.ImageProcessorModel;
import model.ImageProcessorModelImpl;

import static org.junit.Assert.assertEquals;

public class ImageProcessorModelImplTest {

  ImageProcessorModel model;

  @Before
  public void setUp() {
    model = new ImageProcessorModelImpl();
  }

  @Test(expected = IllegalArgumentException.class)
  public void loadNonPPM() {
    model.loadImage("ImageProcessor/res/P2.ppm", "haha");
  }

  @Test(expected = IllegalArgumentException.class)
  public void load404() {
    model.loadImage("ImageProcessor/res/ThisFileDoesnt.Exist", "haha");
  }

  @Test
  public void testLoad() {
    String actual = "";
    try {
      actual = Files.readString(Paths.get("ImageProcessor/res/pix.ppm"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    model.loadImage("ImageProcessor/res/pix.ppm", "Test");
    assertEquals(model.saveImage("Test"), actual);
  }

  @Test(expected = IllegalArgumentException.class)
  public void saveNotInMap() {
    model.saveImage("DoesntExist");
  }
}