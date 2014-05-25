package editorImagens.core;

import java.awt.Color;
import java.awt.image.BufferedImage;

public interface IFachadaEdicaoImagens {

	public abstract void blur(BufferedImage imagem, int windowWidth,
			int windowHeight);

	public abstract Color calcularCorMedia(BufferedImage imagem);

	public abstract void inverterCores(BufferedImage imagem);

	public abstract Color mediaInvertida(BufferedImage imagem);

	public abstract void desaturarCorMedia(BufferedImage imagem);

}