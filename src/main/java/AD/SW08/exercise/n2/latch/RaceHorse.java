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

import java.util.Random;

/**
 * Ein Rennpferd, das durch ein Startsignal losläuft. Nach einer zufälligen Zeit kommt es im Ziel
 * an.
 */
public final class RaceHorse implements Runnable {

    private static final Logger LOG = LogManager.getLogger(RaceHorse.class);
    private final Synch startSignal;
    private volatile Thread runThread;
    private final Random random;
    private boolean isStopped = false;
    private boolean isImZiel = false;

    /**
     * Erzeugt ein Rennpferd, das in die Starterbox eintritt.
     *
     * @param startSignal Starterbox.
     */
    public RaceHorse(Synch startSignal) {
        this.startSignal = startSignal;
        this.random = new Random();
    }

    @Override
    public void run() {
        //Initialisierungsphase
        runThread = Thread.currentThread();
        LOG.info("Rennpferd " + runThread.getName() + " geht in die Box.");
        //Arbeitsphase
        while (!isStopped && !isImZiel) {
            try {
                startSignal.acquire();
                LOG.info("Rennpferd " + runThread.getName() + " laeuft los...");
                Thread.sleep((getRandomNumberInRange(2000,3000)));
            } catch (InterruptedException ex) {
                LOG.warn("Meldung an " + runThread.getName() + ": Rennleitung hat Rennen unterbrochen");
                isStopped = true;
                return;
            }
            isImZiel = true;
            LOG.info("Rennpferd " + runThread.getName() + " ist im Ziel.");
        }
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}

