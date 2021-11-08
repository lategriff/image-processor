package controller.commands;

import model.ImageProcessorModel;
import view.ImageProcessorView;

public class Blur implements ImageProcessorCommand {
  private final String inName;
  private final String outName;

  /**
   * Constructs the {@code Blur} object.
   * @param inName  the image name to do the operation on
   * @param outName the output name
   */
  public Blur(String inName, String outName) {
    this.inName = inName;
    this.outName = outName;
  }

  @Override
  public void complete(ImageProcessorModel m) throws IllegalStateException {
    double[][] filter = {
            {0.0625, 0.125, 0.0625},
            {0.125, 0.25, 0.125},
            {0.0625, 0.125, 0.0625}};
    m.filter(inName, outName, filter);
  }

  @Override
  public void feedback(ImageProcessorView v) throws IllegalStateException {

  }
}
