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
 * Eine Synchronisationshilfe, die es ermöglicht, einen oder mehrere Threads warten zu lassen, bis
 * diese durch andere Threads aufgeweckt werden. Latches sperren so lange, bis sie einmal ausgelöst
 * werden. Danach sind sie frei passierbar.
 */
public class Latch implements Synch {

    private final static Logger LOG = LogManager.getLogger(Latch.class);
    private static Object lock = new Object();

    private boolean isOpenLatch = false;
    private boolean isInterrupted = false;


    @Override
    public synchronized void acquire() throws InterruptedException {
        while (!isOpenLatch) {
            try {
                this.wait();
            } catch (InterruptedException ie) {
                LOG.info(ie.getStackTrace());
                this.isInterrupted = true;
            }
            if (isInterrupted) {
                LOG.warn("Rennleitung hat Rennen abgebrochen");
            }
        }
        LOG.info("Latch is open");
    }

    @Override
    public synchronized void release() {
        this.isOpenLatch = true;
        this.notifyAll();
    }
}
