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
package io.github.astrapi69.design.pattern.observer.event;

import javax.swing.JTextField;

/**
 * The class {@link DemonstrateEventListener} demonstrates the usage of the {@link EventListener}
 * interface It shows how to handle events with and without using an {@link EventObject}, by
 * printing the text from a {@link JTextField} and its reverse to the console.
 */
public class DemonstrateEventListener
{

	/**
	 * The main method to start the demonstration.
	 *
	 * @param args
	 *            the command line arguments
	 */
	public static void main(final String[] args)
	{
		withoutEventObject();
		withEventObject();
	}

	/**
	 * Demonstrates the usage of an {@link EventListener} without using an {@link EventObject} This
	 * method creates listeners that print a string and its reverse to the console.
	 */
	private static void withoutEventObject()
	{
		final EventListener<String> printString = new EventListener<String>()
		{
			@Override
			public void onEvent(final String event)
			{
				System.out.println(event);
			}
		};

		final EventListener<String> printStringReverse = new EventListener<String>()
		{
			@Override
			public void onEvent(final String event)
			{
				System.out.println(new StringBuffer(event).reverse());
			}
		};

		final EventSource<String> eventSource = new EventSubject<>();
		eventSource.add(printString);
		eventSource.add(printStringReverse);
		eventSource.fireEvent("Hallo");
	}

	/**
	 * Demonstrates the usage of an {@link EventListener} with an {@link EventObject} This method
	 * creates listeners that print the text from a {@link JTextField} and its reverse to the
	 * console.
	 */
	private static void withEventObject()
	{
		final EventListener<EventObject<JTextField>> printString = new EventListener<EventObject<JTextField>>()
		{
			@Override
			public void onEvent(final EventObject<JTextField> event)
			{
				System.out.println(event.getSource().getText());
			}
		};

		final EventListener<EventObject<JTextField>> printStringReverse = new EventListener<EventObject<JTextField>>()
		{
			@Override
			public void onEvent(final EventObject<JTextField> event)
			{
				System.out.println(new StringBuffer(event.getSource().getText()).reverse());
			}
		};

		final JTextField tx = new JTextField("Hello");
		final EventObject<JTextField> eventObject = new EventObject<>(tx);
		final EventSource<EventObject<JTextField>> eventSource = new EventSubject<>();
		eventSource.add(printString);
		eventSource.add(printStringReverse);
		eventSource.fireEvent(eventObject);
		tx.setText("good bye...");
		eventSource.fireEvent(eventObject);
	}
}
