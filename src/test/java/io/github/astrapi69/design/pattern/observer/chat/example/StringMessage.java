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
package io.github.astrapi69.design.pattern.observer.chat.example;

import io.github.astrapi69.design.pattern.observer.chat.Message;

/**
 * The class {@link StringMessage} represents a simple text-based message that can be sent and
 * received in a chat room It implements the {@link Message} interface with a {@link String} as the
 * value type.
 */
public class StringMessage implements Message<String>
{
	private static final long serialVersionUID = 1L;
	private String value;

	/**
	 * Default constructor for creating an empty {@code StringMessage}.
	 */
	public StringMessage()
	{
	}

	/**
	 * Constructor for creating a {@code StringMessage} with a specified value.
	 *
	 * @param value
	 *            the text content of the message
	 */
	public StringMessage(String value)
	{
		this.value = value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getValue()
	{
		return value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StringMessage setValue(String value)
	{
		this.value = value;
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		return "StringMessage [value=" + value + "]";
	}
}
