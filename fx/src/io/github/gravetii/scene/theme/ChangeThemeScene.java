package io.github.gravetii.scene.theme;

import io.github.gravetii.scene.FxDimensions;
import io.github.gravetii.scene.FxScene;
import javafx.geometry.Dimension2D;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChangeThemeScene extends FxScene {

  private ChangeThemeSceneBuilder builder;

  public ChangeThemeScene(Stage stage) throws Exception {
    super(stage);
    this.builder = new ChangeThemeSceneBuilder(this.stage, this.root);
    this.build();
  }

  @Override
  protected void build() throws Exception {
    GridPane themesPane = this.builder.loadThemesPane();
    ToolBar footer = this.builder.loadFooter();
    this.showCenter(themesPane);
    this.showBottom(footer);
  }

  @Override
  public String title() {
    return "Change theme";
  }

  @Override
  protected FxDimensions preferredDimensions() {
    return new FxDimensions(
        new Dimension2D(800, 550), new Dimension2D(800, 550), new Dimension2D(800, 550));
  }
}
