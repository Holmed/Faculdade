package editorImagens.core;

import java.awt.image.BufferedImage;
import java.util.Arrays;

import jomp.runtime.OMP;

public class EditorImagens implements IEditorImagens{

	public void blur(BufferedImage imagem, int windowWidth, int windowHeight){
		OMP.setNumThreads(windowWidth);
		
		int imageWidth = imagem.getWidth();
		int imageHeight = imagem.getHeight();
		
		int edgeX = (windowWidth / 2); //rounded down
		int edgeY = (windowHeight / 2); //rounded down

		int xJomp = 0;
		int y = 0;
		
		//vari�veis do algoritmo que devem ser declaradas aqui fora (do contr�rio as threads ficam travadas e ocorre uso excessivo de CPU)
		int[][] colorArray = new int[windowWidth][windowHeight];		
		int fx = 0, fy = 0;
		int iArrays = 0;
		int mediana = 0;				
		
		//omp parallel for private(xJomp, y, colorArray, fx, fy, iArrays, mediana)
		for (xJomp = 0; xJomp < (imageWidth - edgeX * 2); xJomp++) {
			int x = xJomp + edgeX;
			for (y = edgeY; y < (imageHeight - edgeY); y++) {
				for (fx = 0; fx < windowWidth; fx++) {
					for (fy = 0; fy < windowHeight; fy++) {
						colorArray[fx][fy] = imagem.getRGB(x + fx - edgeX, y + fy - edgeY); //&0xff 
					}
				}
				
				Arrays.sort(colorArray, ImageUtil.getIntArrayComparator());
				
				//TODO n�o deveria ser necess�rio fazer essa ordena��o
				for (iArrays = 0; iArrays < colorArray.length; iArrays++) {
					Arrays.sort(colorArray[iArrays]);
				}
				
				mediana = colorArray[windowWidth / 2][windowHeight / 2];
				imagem.setRGB(x, y, mediana);
			}	
		}		
		
//		allocate outputPixelValue[image width][image height]
//				   edgex := (window width / 2) rounded down
//				   edgey := (window height / 2) rounded down
//				   for x from edgex to image width - edgex
//				       for y from edgey to image height - edgey
//				           allocate colorArray[window width][window height]
//				           for fx from 0 to window width
//				               for fy from 0 to window height
//				                   colorArray[fx][fy] := inputPixelValue[x + fx - edgex][y + fy - edgey]
//				           sort all entries in colorArray[][]
//				           outputPixelValue[x][y] := colorArray[window width / 2][window height / 2]
	}

	public void mediana(BufferedImage imagem) {
		int imageWidth = imagem.getWidth();
		int imageHeight = imagem.getHeight();
		
		for (int x = 0; x < imageWidth; x++) {
			for (int y = 0; y < imageHeight; y++) {
								
			}
			
		}
		
	}
}

/*int rgb = img.getRGB(x, y);
int r = (rgb >> 16) & 0xFF;
int g = (rgb >> 8) & 0xFF;
int b = (rgb & 0xFF);*/
