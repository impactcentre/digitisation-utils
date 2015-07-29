/*
 * Copyright (C) 2013 Universidad de Alicante
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package eu.digitisation.utils.text;

import com.ibm.icu.text.CharsetDetector;
import java.io.*;
import java.nio.charset.Charset;

/**
 * Detect the encoding of a text file
 *
 * @author R.C.C.
 */
public class Encoding {

    /**
     *
     * @param file a text file
     * @return the encoding or Charset
     */
    public static Charset detect(File file) {
        CharsetDetector charsetDetector = new CharsetDetector();

        try {
            InputStream is = new BufferedInputStream(new FileInputStream(file));

            charsetDetector.setText(is);

            return Charset.forName(charsetDetector.detect().getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
