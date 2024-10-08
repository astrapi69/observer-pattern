/**
 * The MIT License
 *
 * Copyright (C) 2022 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.design.pattern.observer;

import io.github.astrapi69.design.pattern.observer.api.Observer;
import io.github.astrapi69.design.pattern.observer.api.Subject;
import io.github.astrapi69.design.pattern.observer.exception.ExceptionEvent;

/**
 * The class {@link DemonstrateObserverPattern} demonstrates the use of the observer design pattern
 * with exception events It creates a subject that can notify multiple observers about exception
 * events.
 */
public class DemonstrateObserverPattern
{

	/**
	 * The main method to start the demonstration.
	 *
	 * @param args
	 *            the command line arguments
	 * @throws InterruptedException
	 *             if the thread sleep is interrupted
	 */
	public static void main(final String[] args) throws InterruptedException
	{
		// Create a Subject...
		System.out.println("Create a Subject...");
		final Subject<ExceptionEvent, Observer<ExceptionEvent>> eventSubject = new ExceptionEventSubject();
		// and three Observer...
		System.out.println("and three Observer...");
		new ExceptionEventObserver(eventSubject);
		new ShowExceptionView(eventSubject);
		new GetStacktraceDisplayView(eventSubject);
		// Create the first ExceptionEvent as Observable...
		System.out.println("Create the first ExceptionEvent as Observable...");
		ExceptionEvent exceptionEvent = new ExceptionEvent(
			new Exception("the first ExceptionEvent"));
		// Set the first Observable...
		System.out.println("Set the first Observable...");
		eventSubject.setObservable(exceptionEvent);
		System.out.println("wait 2 seconds...");
		// wait 2 seconds...
		Thread.sleep(2000);
		// Set the second ExceptionEvent as Observable...
		System.out.println("Set the second ExceptionEvent as Observable...");
		exceptionEvent = new ExceptionEvent(new Exception("the second ExceptionEvent"));
		// Set the second Observable...
		System.out.println("Set the second Observable...");
		eventSubject.setObservable(exceptionEvent);
	}
}
