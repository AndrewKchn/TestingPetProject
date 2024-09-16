FROM maven:3.9.6-sapmachine-21

# Обновляем систему и устанавливаем зависимости для Chrome
RUN apt-get update && apt-get install -y \
    wget \
    gnupg2 \
    unzip \
    ca-certificates

# Добавляем репозиторий Chrome
RUN wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list' \
    && apt-get update

# Устанавливаем Google Chrome
RUN apt-get install -y google-chrome-stable

# Проверяем установку Chrome
RUN google-chrome --version

# Устанавливаем ChromeDriver
RUN wget -N https://chromedriver.storage.googleapis.com/114.0.5735.90/chromedriver_linux64.zip \
    && unzip chromedriver_linux64.zip \
    && mv chromedriver /usr/local/bin/ \
    && chmod +x /usr/local/bin/chromedriver

# Устанавливаем другие необходимые зависимости (например, Xvfb для headless режима)
RUN apt-get install -y xvfb

# Устанавливаем переменную окружения для ChromeDriver
ENV WEBDRIVER_CHROME_DRIVER=/usr/local/bin/chromedriver

WORKDIR /usk/workspace

