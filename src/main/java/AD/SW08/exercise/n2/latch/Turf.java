/*
 * Copyright 2020 Hochschule Luzern - Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package AD.SW08.exercise.n2.latch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Eine Rennbahn für das Pferderennen.
 */
public final class Turf {

    private static final Logger LOG = LogManager.getLogger(Turf.class);

    private static Thread[] threadArray = new Thread[10];

    /**
     * Privater Konstruktor.
     */
    private Turf() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final Synch starterBox = new Latch();
        Thread thread;
        for (int i = 1; i < 6; i++) {
            thread = new Thread(new RaceHorse(starterBox), "Horse " + i);
            threadArray[i - 1] = thread;
            thread.start();

        }
        try {
            Thread.sleep(2000);
            LOG.info("Achtung...");
            Thread.sleep(2000);
            LOG.info("Fertig...");
            Thread.sleep(2000);
            LOG.info("Start...");
            starterBox.release();
            Thread.sleep(500);

            if(false) { //hier Rennabbruch ja = true / nein = false
                stopRaceByRaceDirector();
            }
        } catch (InterruptedException ie) {
            LOG.info(ie.getStackTrace());
        }
    }

    private static void stopRaceByRaceDirector() { //Abbruch durch Rennleitung
        for (int i = 0; i <= 4; i++) {
            Thread t = threadArray[i];
            t.interrupt();

        }
    }
}
