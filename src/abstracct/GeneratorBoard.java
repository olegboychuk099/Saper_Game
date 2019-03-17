package abstracct;

/**
 * Інтерфейс GeneratorBoard
 */
public interface GeneratorBoard {

	/**
	 * Генерує масив комірок для поля гри
	 * 
	 * @param resX
	 *            кількість комірок по осі
	 * @param resY
	 *            кількість комірок по осі
	 * @param numBombs
	 *            число бомб на полі
	 * @return масив комірок для бомб
	 */
	Cell[][] generate(int resX, int resY, int numBombs);

	/**
	 * Получити число бомб на полі
	 * 
	 * @return число бомб
	 */
	int getNumBombs();
}
